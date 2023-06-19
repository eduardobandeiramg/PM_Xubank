import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Interface_Cadastro implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralwidget;
    public QFrame framePrincipal;
    public QFrame frameLogin;
    public QLineEdit textNome;
    public QLineEdit textSobrenome;
    public QPushButton buttomCadastrar;
    public QLabel label;
    public QLineEdit textCPF;
    public QLineEdit textNascimento;
    public QLineEdit textSenha;
    public QLineEdit textConfirmarSenha;

    public Interface_Cadastro() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(600, 800).expandedTo(MainWindow.minimumSizeHint()));
        MainWindow.setMinimumSize(new QSize(600, 800));
        MainWindow.setMaximumSize(new QSize(600, 800));
        MainWindow.setWindowIcon(new QIcon(new QPixmap("../Imagens/nubank.png")));
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        framePrincipal = new QFrame(centralwidget);
        framePrincipal.setObjectName("framePrincipal");
        framePrincipal.setGeometry(new QRect(0, 0, 601, 801));
        framePrincipal.setStyleSheet("background-color: rgb(130, 10, 209);");
        framePrincipal.setFrameShape(QFrame.Shape.StyledPanel);
        framePrincipal.setFrameShadow(QFrame.Shadow.Raised);
        frameLogin = new QFrame(framePrincipal);
        frameLogin.setObjectName("frameLogin");
        frameLogin.setGeometry(new QRect(50, 220, 481, 411));
        frameLogin.setStyleSheet("background-color: rgb(130, 10, 209);\n"+
"background-color: rgb(105, 8, 170);\n"+
"border-radius: 10px;");
        frameLogin.setFrameShape(QFrame.Shape.StyledPanel);
        frameLogin.setFrameShadow(QFrame.Shadow.Raised);
        textNome = new QLineEdit(frameLogin);
        textNome.setObjectName("textNome");
        textNome.setGeometry(new QRect(50, 70, 181, 41));
        textNome.setStyleSheet("QLineEdit{\n"+
"font: 75 12pt \"MS Shell Dlg 2\";\n"+
"background-color: rgb(255, 255, 255);\n"+
"border-radius: 10px;\n"+
"color: rgb(182, 182, 182);\n"+
"}\n"+
"QLineEdit:focus{\n"+
"	color: rgb(35, 35, 35);\n"+
"}");
        textNome.setAlignment(Qt.AlignmentFlag.createQFlags(Qt.AlignmentFlag.AlignLeft, Qt.AlignmentFlag.AlignVCenter));
        textNome.setCursorMoveStyle(Qt.CursorMoveStyle.LogicalMoveStyle);
        textSobrenome = new QLineEdit(frameLogin);
        textSobrenome.setObjectName("textSobrenome");
        textSobrenome.setGeometry(new QRect(250, 70, 181, 41));
        textSobrenome.setStyleSheet("QLineEdit{\n"+
"font: 75 12pt \"MS Shell Dlg 2\";\n"+
"background-color: rgb(255, 255, 255);\n"+
"border-radius: 10px;\n"+
"color: rgb(182, 182, 182);\n"+
"}\n"+
"QLineEdit:focus{\n"+
"	color: rgb(35, 35, 35);\n"+
"}");
        textSobrenome.setAlignment(Qt.AlignmentFlag.createQFlags(Qt.AlignmentFlag.AlignLeft, Qt.AlignmentFlag.AlignVCenter));
        buttomCadastrar = new QPushButton(frameLogin);
        buttomCadastrar.setObjectName("buttomLogin");
        buttomCadastrar.setGeometry(new QRect(140, 320, 201, 41));
        buttomCadastrar.setStyleSheet("QPushButton{\n"+
"	background-color: rgb(255, 255, 255);\n"+
"	border-radius: 10px;\n"+
"	font: 75 10pt \"MS Shell Dlg 2\";\n"+
"}\n"+
"QPushButton:hover{\n"+
"\n"+
"	background-color: rgb(220, 220, 220);\n"+
"}\n"+
"QPushButton:pressed{\n"+
"\n"+
"	background-color: rgb(234, 234, 234);\n"+
"}\n"+
"\n"+
"");
        label = new QLabel(frameLogin);
        label.setObjectName("label");
        label.setGeometry(new QRect(150, 10, 171, 51));
        label.setStyleSheet("font: 75 22pt \"MS Shell Dlg 2\";\n"+
"color: rgb(255, 255, 255);");
        label.setAlignment(Qt.AlignmentFlag.createQFlags(Qt.AlignmentFlag.AlignCenter));
        textCPF = new QLineEdit(frameLogin);
        textCPF.setObjectName("textCPF");
        textCPF.setGeometry(new QRect(50, 150, 181, 41));
        textCPF.setStyleSheet("QLineEdit{\n"+
"font: 75 12pt \"MS Shell Dlg 2\";\n"+
"background-color: rgb(255, 255, 255);\n"+
"border-radius: 10px;\n"+
"color: rgb(182, 182, 182);\n"+
"}\n"+
"QLineEdit:focus{\n"+
"	color: rgb(35, 35, 35);\n"+
"}");
        textCPF.setAlignment(Qt.AlignmentFlag.createQFlags(Qt.AlignmentFlag.AlignLeft, Qt.AlignmentFlag.AlignVCenter));
        textCPF.setCursorMoveStyle(Qt.CursorMoveStyle.LogicalMoveStyle);
        textNascimento = new QLineEdit(frameLogin);
        textNascimento.setObjectName("textNascimento");
        textNascimento.setGeometry(new QRect(250, 150, 181, 41));
        textNascimento.setStyleSheet("QLineEdit{\n"+
"font: 75 12pt \"MS Shell Dlg 2\";\n"+
"background-color: rgb(255, 255, 255);\n"+
"border-radius: 10px;\n"+
"color: rgb(182, 182, 182);\n"+
"}\n"+
"QLineEdit:focus{\n"+
"	color: rgb(35, 35, 35);\n"+
"}");
        textNascimento.setAlignment(Qt.AlignmentFlag.createQFlags(Qt.AlignmentFlag.AlignLeft, Qt.AlignmentFlag.AlignVCenter));
        textNascimento.setCursorMoveStyle(Qt.CursorMoveStyle.LogicalMoveStyle);
        textSenha = new QLineEdit(frameLogin);
        textSenha.setObjectName("textSenha");
        textSenha.setGeometry(new QRect(50, 230, 181, 41));
        textSenha.setStyleSheet("QLineEdit{\n"+
"font: 75 12pt \"MS Shell Dlg 2\";\n"+
"background-color: rgb(255, 255, 255);\n"+
"border-radius: 10px;\n"+
"color: rgb(182, 182, 182);\n"+
"}\n"+
"QLineEdit:focus{\n"+
"	color: rgb(35, 35, 35);\n"+
"}");
        textSenha.setAlignment(Qt.AlignmentFlag.createQFlags(Qt.AlignmentFlag.AlignLeft, Qt.AlignmentFlag.AlignVCenter));
        textSenha.setCursorMoveStyle(Qt.CursorMoveStyle.LogicalMoveStyle);
        textConfirmarSenha = new QLineEdit(frameLogin);
        textConfirmarSenha.setObjectName("textConfirmarSenha");
        textConfirmarSenha.setGeometry(new QRect(250, 230, 181, 41));
        textConfirmarSenha.setStyleSheet("QLineEdit{\n"+
"font: 75 12pt \"MS Shell Dlg 2\";\n"+
"background-color: rgb(255, 255, 255);\n"+
"border-radius: 10px;\n"+
"color: rgb(182, 182, 182);\n"+
"}\n"+
"QLineEdit:focus{\n"+
"	color: rgb(35, 35, 35);\n"+
"}");
        textConfirmarSenha.setAlignment(Qt.AlignmentFlag.createQFlags(Qt.AlignmentFlag.AlignLeft, Qt.AlignmentFlag.AlignVCenter));
        textConfirmarSenha.setCursorMoveStyle(Qt.CursorMoveStyle.LogicalMoveStyle);
        MainWindow.setCentralWidget(centralwidget);
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    }

    void retranslateUi(QMainWindow MainWindow){

        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Xubank", null));
        textNome.setInputMask("");
        textNome.setText("");
        textNome.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Nome", null));
        textSobrenome.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Sobrenome", null));
        buttomCadastrar.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Cadastrar", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Cadastro", null));
        textCPF.setInputMask("");
        textCPF.setText("");
        textCPF.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "CPF", null));
        textNascimento.setInputMask("");
        textNascimento.setText("");
        textNascimento.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Data Nascimento", null));
        textSenha.setInputMask("");
        textSenha.setText("");
        textSenha.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Senha", null));
        textConfirmarSenha.setInputMask("");
        textConfirmarSenha.setText("");
        textConfirmarSenha.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Tipo de Conta", null));
    }

}

