module UIDesignAssignment{
	requires javafx.graphics; 
	requires javafx.controls;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
