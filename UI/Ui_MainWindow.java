/********************************************************************************
 ** Form generated from reading ui file 'Interface_Cadastro.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralwidget;
    public QFrame framePrincipal;
    public QFrame frameLogin;
    public QLineEdit textNome;
    public QLineEdit textSobrenome;
    public QPushButton buttomLogin;
    public QLabel label;
    public QLineEdit textCPF;
    public QLineEdit textNascimento;
    public QLineEdit textSenha;
    public QLineEdit textConfirmarSenha;
    public QPushButton buttomVoltar;

    public Ui_MainWindow() { super(); }

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
        framePrincipal.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        framePrincipal.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        frameLogin = new QFrame(framePrincipal);
        frameLogin.setObjectName("frameLogin");
        frameLogin.setGeometry(new QRect(50, 220, 491, 411));
        frameLogin.setStyleSheet("background-color: rgb(130, 10, 209);\n"+
"background-color: rgb(105, 8, 170);\n"+
"border-radius: 10px;");
        frameLogin.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameLogin.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
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
        textNome.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        textNome.setCursorMoveStyle(com.trolltech.qt.core.Qt.CursorMoveStyle.LogicalMoveStyle);
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
        textSobrenome.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        buttomLogin = new QPushButton(frameLogin);
        buttomLogin.setObjectName("buttomLogin");
        buttomLogin.setGeometry(new QRect(140, 320, 201, 41));
        buttomLogin.setStyleSheet("QPushButton{\n"+
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
        label.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
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
        textCPF.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        textCPF.setCursorMoveStyle(com.trolltech.qt.core.Qt.CursorMoveStyle.LogicalMoveStyle);
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
        textNascimento.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        textNascimento.setCursorMoveStyle(com.trolltech.qt.core.Qt.CursorMoveStyle.LogicalMoveStyle);
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
        textSenha.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        textSenha.setCursorMoveStyle(com.trolltech.qt.core.Qt.CursorMoveStyle.LogicalMoveStyle);
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
        textConfirmarSenha.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        textConfirmarSenha.setCursorMoveStyle(com.trolltech.qt.core.Qt.CursorMoveStyle.LogicalMoveStyle);
        buttomVoltar = new QPushButton(frameLogin);
        buttomVoltar.setObjectName("buttomVoltar");
        buttomVoltar.setGeometry(new QRect(210, 370, 61, 21));
        buttomVoltar.setStyleSheet("border: none;\n"+
"font: 75 8pt \"MS Shell Dlg 2\";\n"+
"color: rgb(255, 255, 255);");
        MainWindow.setCentralWidget(centralwidget);
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Xubank", null));
        textNome.setInputMask("");
        textNome.setText("");
        textNome.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Nome", null));
        textSobrenome.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Sobrenome", null));
        buttomLogin.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Cadastrar", null));
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
        buttomVoltar.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Login", null));
    } // retranslateUi

}

