public class PruebaUsuarios {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println("====================================");
        System.out.println("   SISTEMA DE GESTIÓN DE USUARIOS");
        System.out.println("   INMOBILIARIA DPG");
        System.out.println("====================================");

        System.out.println();
        System.out.println("USUARIOS REGISTRADOS:");
        System.out.println("------------------------------------");

        usuarioDAO.listarUsuarios();

        System.out.println();
        System.out.println("====================================");
        System.out.println("Consulta finalizada correctamente.");
        System.out.println("====================================");
    }
}