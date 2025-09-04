import java.util.regex.Pattern;

public class Placa {
    private String codigo; // LLLNLNN

    public Placa(String codigo) {
        if (Pattern.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}", codigo)) {
            this.codigo = codigo;
        } else {
            this.codigo = "AAA0A00";
        }
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        if (codigo.equals("AAA0A00")) {
            return "Invalida!";
        } else {
            return codigo;
        }
    }
}