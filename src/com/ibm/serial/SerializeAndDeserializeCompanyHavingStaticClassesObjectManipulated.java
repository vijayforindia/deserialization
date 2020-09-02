/**
 * 
 */
package com.ibm.serial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;

import com.ibm.serial.CompanyHavingStaticClasses.ClientConfig;

/**
 * @author vijaykumar
 *
 */
public class SerializeAndDeserializeCompanyHavingStaticClassesObjectManipulated {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompanyHavingStaticClasses companyHavingStaticClasses = new CompanyHavingStaticClasses(1, "MyCompany", 5);
		//CompanyHavingStaticClasses.SCConfig innerSatticSCConfig = new CompanyHavingStaticClasses(5, "ForStatic Company",9).SCConfig.agentToScHBInterval;
		SudoCompany sudoCompany = new SudoCompany(2, "OwnCompany", 6, "SudoCompany");

		byte[] serializedCompanyHavingStaticClassesObject;

		byte[] serializedSudoCompany;

		try {
			companyHavingStaticClasses.setSignature("Sanjay");
			serializedCompanyHavingStaticClassesObject = serialized(companyHavingStaticClasses);
			
			companyHavingStaticClasses.setSignature("Vijay Kumar");
			serializedSudoCompany = serialized(sudoCompany);
			//SCConfig extends ClientConfig
			CompanyHavingStaticClasses desirializedObject = (CompanyHavingStaticClasses) deserialized(serializedCompanyHavingStaticClassesObject);
			System.out.println(desirializedObject.getCompanyName() + " got deserialized");
			//System.out.println(desirializedObject.SCConfig.agentToScHBInterval);
			System.out.println(desirializedObject.getSignature() + " got deserialized");

			//SudoCompany deserialixedObject2 = (SudoCompany) deserialized(serializedSudoCompany);
			//System.out.println(deserialixedObject2.getOtherMainWork() + " got deserialized");
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
