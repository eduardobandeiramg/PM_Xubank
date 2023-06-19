import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

import javax.naming.directory.InvalidAttributesException;

public class InterfaceGrafica implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralwidget;
    public QFrame framePrincipal;
    public QFrame frameLogin;
    public QFrame frameCadastro;
    public QLineEdit textLogin;
    public QLineEdit textPassword;
    public QPushButton buttomLogin;
    public QLabel labelLogin;
    public QLabel labelCadastro;
    public QCheckBox checkBox;
    public QLabel ImagemPrincipal;
    public QLineEdit textNome;
    public QLineEdit textSobrenome;
    public QLineEdit textCPF;
    public QLineEdit textNascimento;
    public QLineEdit textSenha;
    public QLineEdit textTipoConta;
    public QPushButton buttomCadastrar;
    public QPushButton buttomCadastro;
    public QPushButton buttomVoltar;

    public InterfaceGrafica() {
        super();

    }

    public void setupUi(QMainWindow MainWindow){

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
        frameLogin.setGeometry(new QRect(60, 260, 481, 311));
        frameLogin.setStyleSheet("background-color: rgb(130, 10, 209);\n"+
"background-color: rgb(105, 8, 170);\n"+
"border-radius: 10px;");
        frameLogin.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameLogin.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        frameLogin.hide();
        frameCadastro = new QFrame(framePrincipal);
        frameCadastro.setObjectName("frameLogin");
        frameCadastro.setGeometry(new QRect(50, 220, 491, 411));
        frameCadastro.setStyleSheet("background-color: rgb(130, 10, 209);\n"+
                "background-color: rgb(105, 8, 170);\n"+
                "border-radius: 10px;");
        frameCadastro.setFrameShape(QFrame.Shape.StyledPanel);
        frameCadastro.setFrameShadow(QFrame.Shadow.Raised);
        frameCadastro.hide();
        textLogin = new QLineEdit(frameLogin);
        textLogin.setObjectName("textLogin");
        textLogin.setGeometry(new QRect(30, 70, 411, 41));
        textLogin.setStyleSheet("QLineEdit{\n"+
"font: 75 12pt \"MS Shell Dlg 2\";\n"+
"background-color: rgb(255, 255, 255);\n"+
"border-radius: 10px;\n"+
"color: rgb(182, 182, 182);\n"+
"}\n"+
"QLineEdit:focus{\n"+
"	color: rgb(35, 35, 35);\n"+
"}");
        textLogin.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        textLogin.setCursorMoveStyle(com.trolltech.qt.core.Qt.CursorMoveStyle.LogicalMoveStyle);
        textLogin.hide();
        textPassword = new QLineEdit(frameLogin);
        textPassword.setObjectName("textPassword");
        textPassword.setGeometry(new QRect(30, 130, 411, 41));
        textPassword.setStyleSheet("QLineEdit{\n"+
"font: 75 12pt \"MS Shell Dlg 2\";\n"+
"background-color: rgb(255, 255, 255);\n"+
"border-radius: 10px;\n"+
"color: rgb(182, 182, 182);\n"+
"}\n"+
"QLineEdit:focus{\n"+
"	color: rgb(35, 35, 35);\n"+
"}");
        textPassword.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        textPassword.hide();
        buttomLogin = new QPushButton(frameLogin);
        buttomLogin.setObjectName("buttomLogin");
        buttomLogin.setGeometry(new QRect(140, 220, 201, 41));
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
        buttomLogin.hide();
        labelLogin = new QLabel(frameLogin);
        labelLogin.setObjectName("labelLogin");
        labelLogin.setGeometry(new QRect(150, 10, 171, 51));
        labelLogin.setStyleSheet("font: 75 22pt \"MS Shell Dlg 2\";\n"+
"color: rgb(255, 255, 255);");
        labelLogin.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        labelLogin.hide();
        labelCadastro = new QLabel(frameCadastro);
        labelCadastro.setObjectName("labelCadastro");
        labelCadastro.setGeometry(new QRect(150, 10, 171, 51));
        labelCadastro.setStyleSheet("font: 75 22pt \"MS Shell Dlg 2\";\n"+
                "color: rgb(255, 255, 255);");
        labelCadastro.setAlignment(Qt.AlignmentFlag.createQFlags(Qt.AlignmentFlag.AlignCenter));
        labelCadastro.hide();
        checkBox = new QCheckBox(frameLogin);
        checkBox.setObjectName("checkBox");
        checkBox.setGeometry(new QRect(30, 190, 141, 16));
        checkBox.setStyleSheet("font: 75 10pt \"MS Shell Dlg 2\";\n"+
"color: rgb(255, 255, 255);");
        checkBox.hide();
        ImagemPrincipal = new QLabel(framePrincipal);
        ImagemPrincipal.setObjectName("ImagemPrincipal");
        ImagemPrincipal.setGeometry(new QRect(160, 10, 271, 241));
        ImagemPrincipal.setPixmap(new QPixmap("../Imagens/nubank.png"));
        ImagemPrincipal.setScaledContents(true);
        ImagemPrincipal.hide();
        textNome = new QLineEdit(frameCadastro);
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
        textNome.hide();
        textSobrenome = new QLineEdit(frameCadastro);
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
        textSobrenome.hide();
        textCPF = new QLineEdit(frameCadastro);
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
        textCPF.hide();
        textNascimento = new QLineEdit(frameCadastro);
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
        textNascimento.hide();
        textSenha = new QLineEdit(frameCadastro);
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
        textSenha.hide();
        textTipoConta = new QLineEdit(frameCadastro);
        textTipoConta.setObjectName("textConfirmarSenha");
        textTipoConta.setGeometry(new QRect(250, 230, 181, 41));
        textTipoConta.setStyleSheet("QLineEdit{\n"+
                "font: 75 12pt \"MS Shell Dlg 2\";\n"+
                "background-color: rgb(255, 255, 255);\n"+
                "border-radius: 10px;\n"+
                "color: rgb(182, 182, 182);\n"+
                "}\n"+
                "QLineEdit:focus{\n"+
                "	color: rgb(35, 35, 35);\n"+
                "}");
        textTipoConta.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        textTipoConta.setCursorMoveStyle(com.trolltech.qt.core.Qt.CursorMoveStyle.LogicalMoveStyle);
        textTipoConta.hide();
        buttomCadastrar = new QPushButton(frameCadastro);
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
        buttomCadastrar.hide();
        buttomCadastro = new QPushButton(frameLogin);
        buttomCadastro.setObjectName("buttomCadastro");
        buttomCadastro.setGeometry(new QRect(210, 270, 61, 21));
        buttomCadastro.setStyleSheet("border: none;\n"+
                "font: 75 8pt \"MS Shell Dlg 2\";\n"+
                "color: rgb(255, 255, 255);");
        buttomCadastro.hide();
        buttomVoltar = new QPushButton(frameCadastro);
        buttomVoltar.setObjectName("buttomVoltar");
        buttomVoltar.setGeometry(new QRect(210, 370, 61, 21));
        buttomVoltar.setStyleSheet("border: none;\n"+
                "font: 75 8pt \"MS Shell Dlg 2\";\n"+
                "color: rgb(255, 255, 255);");
        buttomVoltar.hide();

        MainWindow.setCentralWidget(centralwidget);
        setTextPadrao(MainWindow);

        setUpTelaLogin();
        initButtoms();

        MainWindow.connectSlotsByName();

    }

    private void setTextPadrao(QMainWindow MainWindow){

        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Xubank", null));
        textLogin.setInputMask("");
        textLogin.setText("");
        textLogin.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Usu\u00e1rio", null));
        textPassword.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Senha", null));
        buttomLogin.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Entrar", null));
        labelLogin.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Login", null));
        checkBox.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Remember me", null));
        ImagemPrincipal.setText("");
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Xubank", null));
        textNome.setInputMask("");
        textNome.setText("");
        textNome.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Nome", null));
        textSobrenome.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Sobrenome", null));
        buttomCadastrar.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Cadastrar", null));
        labelCadastro.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Cadastro", null));
        textCPF.setInputMask("");
        textCPF.setText("");
        textCPF.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "CPF", null));
        textNascimento.setInputMask("");
        textNascimento.setText("");
        textNascimento.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Data Nascimento", null));
        textSenha.setInputMask("");
        textSenha.setText("");
        textSenha.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Senha", null));
        textTipoConta.setInputMask("");
        textTipoConta.setText("");
        textTipoConta.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Tipo de Conta", null));
        buttomCadastro.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Cadastrar", null));

    }

    private void initButtoms(){

        buttomCadastro.clicked.connect(this, "setUpTelaCadastro()");
        buttomCadastrar.clicked.connect(this, "cadastrar()");

    }

    private void setUpTelaLogin(){

        frameCadastro.hide();
        textNome.hide();
        labelCadastro.hide();
        textSenha.hide();
        textNascimento.hide();
        textCPF.hide();
        textSobrenome.hide();
        textTipoConta.hide();

        frameLogin.show();
        textLogin.show();
        labelLogin.show();
        textPassword.show();
        frameLogin.show();
        buttomLogin.show();
        checkBox.show();
        buttomCadastro.show();

    }

    private void setUpTelaCadastro(){

        frameLogin.hide();
        labelLogin.hide();
        textLogin.hide();
        textPassword.hide();
        buttomLogin.hide();
        checkBox.hide();
        buttomCadastro.hide();

        frameCadastro.show();
        labelCadastro.show();
        textNome.show();
        textSenha.show();
        textNascimento.show();
        textCPF.show();
        textSobrenome.show();
        textTipoConta.show();
        buttomCadastrar.show();


    }

    private void cadastrar() throws InvalidAttributesException {

        setUpTelaLogin();

        String nome = textNome.text();
        nome = nome + " " + textSobrenome.text();

        String data = textNascimento.text();
        String cpf = textCPF.text();
        String conta = textTipoConta.text();
        String senha = textSenha.text();

        Cliente novoCliente = new Cliente(nome, data, cpf, conta, senha);

        System.out.println(novoCliente.descricaoCliente());

    }

}

