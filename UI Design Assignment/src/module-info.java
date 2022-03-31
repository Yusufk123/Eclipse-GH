module UIDesignAssignment{
	requires javafx.graphics; 
	requires javafx.controls;
	requires javafx.base;
	requires junit;
	
	opens application to javafx.graphics, javafx.fxml;
}
