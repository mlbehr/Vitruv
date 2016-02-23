package edu.kit.ipd.sdq.vitruvius.dsls.response.tests.pcmjava

import org.palladiosimulator.pcm.repository.RepositoryComponent
import org.palladiosimulator.pcm.repository.Repository
import org.palladiosimulator.pcm.repository.Interface
import org.eclipse.emf.ecore.EObject
import org.palladiosimulator.pcm.core.entity.Entity
import org.emftext.language.java.containers.CompilationUnit
import org.emftext.language.java.modifiers.ModifiersFactory
import org.emftext.language.java.classifiers.ConcreteClassifier

class PCMJavaHelper {
	private static def String getQualifiedName(Repository repository) {
		repository.entityName.toFirstLower.trim;
	}
	
	public static final val interfaceToInterface = new CorrespondingInterface();
	public static final val repositoryToPackageInfo = new CorrespondingRepositoryPackageInfo();
	public static final val repositoryToContractsPackageInfo = new CorrespondingContractsRepositoryPackageInfo();
	public static final val repositoryToDatatypesPackageInfo = new CorrespondingDatatypesRepositoryPackageInfo();
	public static final val componentToPackageInfo = new CorrespondingComponentPackageInfo();
	public static final val componentToClass = new CorrespondingJavaClass();
		
	public abstract static class CorrespondingClass<E extends EObject> {
		public abstract def String getClassName(E object);
		public abstract def String getPackageName(E object);
		public def String getQualifiedClassName(E object) {
			return object.packageName + "." + object.className;
		}
		public def String getPathInProject(E object) {
			return "src/" + object.qualifiedClassName.replace(".", "/") + ".java";
		}
	}
	
	public abstract static class CorrespondingToEntityClass<E extends Entity> extends CorrespondingClass<E> {
		override getClassName(E object) {
			return object.entityName.toFirstUpper;
		}
	}
	
	public abstract static class CorrespondingPackageInfo<E extends Entity> extends CorrespondingToEntityClass<E> {
		override getClassName(E object) {
			return "package-info";
		}
	}
	
	public static class CorrespondingInterface extends CorrespondingToEntityClass<Interface> {
		override getPackageName(Interface object) {
			object.repository__Interface.qualifiedName.toFirstLower;
		}
	}
	
	public static class CorrespondingRepositoryPackageInfo extends CorrespondingPackageInfo<Repository> {
		override getPackageName(Repository object) {
			object.qualifiedName.toFirstLower;
		}
	}
	
	public static class CorrespondingContractsRepositoryPackageInfo extends CorrespondingPackageInfo<Repository> {
		override getPackageName(Repository object) {
			object.qualifiedName.toFirstLower + ".contracts";
		}
	}
	
	public static class CorrespondingDatatypesRepositoryPackageInfo extends CorrespondingPackageInfo<Repository> {
		override getPackageName(Repository object) {
			object.qualifiedName.toFirstLower + ".datatypes";
		}
	}
	
	public static class CorrespondingComponentPackageInfo extends CorrespondingToEntityClass<RepositoryComponent> {
		override getClassName(RepositoryComponent object) {
			return "package-info";
		}
		
		override getPackageName(RepositoryComponent object) {
			object.repository__RepositoryComponent.qualifiedName.toFirstLower + "." + object.entityName.toFirstLower;
		}
	}
	
	public static class CorrespondingJavaClass extends CorrespondingToEntityClass<RepositoryComponent> {
		override getClassName(RepositoryComponent object) {
			return super.getClassName(object) + "Impl";
		}
		
		override getPackageName(RepositoryComponent object) {
			return object.repository__RepositoryComponent.qualifiedName.toFirstLower + "." + object.entityName.toFirstLower;
		}
	}
	
	public static def void initializeCompilationUnitAndJavaClassifier(CompilationUnit compilationUnit, ConcreteClassifier javaClassifier, String name) {
		compilationUnit.name = name;
		javaClassifier.name = name;
		javaClassifier.addModifier(ModifiersFactory.eINSTANCE.createPublic());
		compilationUnit.classifiers.add(javaClassifier);
	}
	
}