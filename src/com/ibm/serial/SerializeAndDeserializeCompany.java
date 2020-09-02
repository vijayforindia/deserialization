/**
 * 
 */
package com.ibm.serial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;

/**
 * @author vijaykumar
 *
 */
public class SerializeAndDeserializeCompany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Company company = new Company(1, "MyCompany", 5);
		Integer integer = new Integer(876);

		byte[] serializedCompanyObject;
		byte[] serializedIntenger;

		try {
			serializedCompanyObject = serialized(company);

			serializedIntenger = serialized(integer);

			Company desirializedObject = (Company) deserialized(serializedCompanyObject);
			System.out.println(desirializedObject.getCompanyName() + " got deserialized");
			System.out.println(desirializedObject.getNoOfSisterCompany() + " got deserialized");
			Company desirializedObject1 = (Company) deserialized(serializedIntenger);

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	private static byte[] serialized(Object object) throws IOException {
		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
			objectOutputStream.writeObject(object);
			byte[] buffer = byteArrayOutputStream.toByteArray();
//			objectOutputStream.close();
//			byteArrayOutputStream.close();
			return buffer;
		}
	}

	private static Object deserialized(byte[] buffer) throws IOException, ClassNotFoundException {
		try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
				final ValidatingObjectInputStream objectInputStream = new ValidatingObjectInputStream(
						byteArrayInputStream).accept(Company.class).accept("com.ibm.serial.Company")) {
			return objectInputStream.readObject();
		}
	}
}
