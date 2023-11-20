module bennyngo.hwcs151javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens bennyngo.hwcs151javafx to javafx.fxml;
    exports bennyngo.hwcs151javafx;
}