/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author USUARIO
 */

import java.sql.*;

public class ConexionBD {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Paso 4: cargar el controlador JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Paso 5: datos de conexión
        String url = "jdbc:mysql://localhost:3307/registro_usuarios";
        String usuario = "root";
        String contraseña = "";

        // Crear la conexión
        Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

        // Paso 6: crear el objeto Statement
        Statement sentencia = conexion.createStatement();

        // Paso 7: crear y ejecutar la consulta SQL
        String sql = "SELECT * FROM usuarios";
        ResultSet resultado = sentencia.executeQuery(sql);

       while (resultado.next()) {
    for (int i = 1; i <= resultado.getMetaData().getColumnCount(); i++) {
        System.out.print(resultado.getMetaData().getColumnName(i) + ": ");
        System.out.print(resultado.getString(i) + " | ");
    }
    System.out.println();
}

    }
}
