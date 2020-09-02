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
public class SerializeAndDeserializeCompanyHavingStaticClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompanyHavingStaticClasses companyHavingStaticClasses = new CompanyHavingStaticClasses(1, "MyCompany", 5);

		SudoCompany sudoCompany = new SudoCompany(2, "OwnCompany", 6, "SudoCompany");

		byte[] serializedCompanyHavingStaticClassesObject;

		byte[] serializedSudoCompany;

		try {
			serializedCompanyHavingStaticClassesObject = serialized(companyHavingStaticClasses);

			serializedSudoCompany = serialized(sudoCompany);

			CompanyHavingStaticClasses desirializedObject = (CompanyHavingStaticClasses) deserialized(serializedCompanyHavingStaticClassesObject);
			System.out.println(desirializedObject.getCompanyName() + " got deserialized");
			System.out.println(desirializedObject.getNoOfSisterCompany() + " got deserialized");

			SudoCompany deserialixedObject2 = (SudoCompany) deserialized(serializedSudoCompany);
			System.out.println(deserialixedObject2.getOtherMainWork() + " got deserialized");
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
						byteArrayInputStream).accept(CompanyHavingStaticClasses.class).accept("com.ibm.serial.CompanyHavingStaticClasses")
		/* .accept(SudoCompany.class) */) {
			return objectInputStream.readObject();
		}

	}
}
