module DeploymentAssignment {
	requires javafx.controls;
	requires jdk.internal.vm.compiler;

	opens application to javafx.graphics, javafx.fxml;
}
