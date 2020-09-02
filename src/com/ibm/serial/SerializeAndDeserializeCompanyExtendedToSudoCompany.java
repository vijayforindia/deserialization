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
public class SerializeAndDeserializeCompanyExtendedToSudoCompany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Company company = new Company(1, "MyCompany", 5);
		Integer integer = new Integer(876);
		TestCompany testCompany = new TestCompany(3, "sdfhds", 88);
		SudoCompany sudoCompany = new SudoCompany(2, "OwnCompany", 6, "SudoCompany");
		
		byte[] serializedCompanyObject;
		byte[] serializedIntenger;
		byte [] serializedSudoCompany;
		byte[] serializedTestCompamy;
		try {
			serializedCompanyObject = serialized(company);
			company.setNoOfSisterCompany(8);
			//serializedCompanyObject.setNoOfSisterCompany(9);
			serializedIntenger = serialized(integer);
			serializedSudoCompany = serialized(sudoCompany);
			serializedTestCompamy = serialized(testCompany);
			testCompany.number = 99;
			Company desirializedObject = (Company) deserialized(serializedCompanyObject);
			System.out.println(desirializedObject.getCompanyName() + " got deserialized");
			System.out.println(desirializedObject.getNoOfSisterCompany() + " got deserialized");
			//Company desirializedObject1 = (Company) deserialized(serializedIntenger);
			SudoCompany deserialixedObject2 = (SudoCompany) deserialized(serializedSudoCompany);
			TestCompany serializedTestCompamy1 = (TestCompany) deserialized(serializedTestCompamy);
			System.out.println("serializedTestCompamy1  "+ serializedTestCompamy1.number);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	private static byte[] serialized(Object object) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(object);
		byte[] buffer = byteArrayOutputStream.toByteArray();
		objectOutputStream.close();
		byteArrayOutputStream.close();
		return buffer;
	}

	private static Object deserialized(byte[] buffer) throws IOException, ClassNotFoundException {
		try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
				final ValidatingObjectInputStream objectInputStream = new ValidatingObjectInputStream(
						byteArrayInputStream).accept(Company.class)
						.accept("com.ibm.serial.Company")
						.accept(TestCompany.class)
						.accept(SudoCompany.class)) {
			return objectInputStream.readObject();
		}finally {
			System.out.println("Deserialized done");
		}

	}
}
