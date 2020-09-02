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
public class SerializeAndDeserializeCompanyObjectManipulated {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Company company = new Company(1, "MyCompany", 5);
		byte[] serializedCompanyObject;
		try {
			serializedCompanyObject = serialized(company);
			//manipulating the object of company
			company.setNoOfSisterCompany(8);
			Company desirializedObject = (Company) deserialized(serializedCompanyObject);
			System.out.println(desirializedObject.getCompanyName() + " got deserialized");
			System.out.println(desirializedObject.getNoOfSisterCompany() + " got deserialized");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	private static byte[] serialized(Object object) throws IOException {
		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);) {
			objectOutputStream.writeObject(object);
			return byteArrayOutputStream.toByteArray();
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
