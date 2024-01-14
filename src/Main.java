import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/estudiantes";
        String dbUsername = "root";
        String dbPassword = "moni123";
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Ingresar estudiantes");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Actualizar estudiantes");
            System.out.println("4. Eliminar estudiantes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            if (opcion == 1) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                    String sql = "INSERT INTO calificaciones VALUES (?, ?, ?, ?,?)";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    int id;
                    String nombre;
                    int cedula;
                    float nota1;
                    float nota2;

                    System.out.println("Ingrese el id del estudiante: ");
                    id = scanner.nextInt();

                    System.out.println("Ingrese el nombre del estudiante: ");
                    nombre = scanner.next();

                    System.out.println("Ingrese la cedula del estudiante: ");
                    cedula = scanner.nextInt();

                    System.out.println("Ingrese la nota 1 del estudiante: ");
                    nota1 = scanner.nextFloat();

                    System.out.println("Ingrese la nota 2 del estudiante: ");
                    nota2 = scanner.nextFloat();

                    statement.setInt(1, id);
                    statement.setString(2, nombre);
                    statement.setInt(3, cedula);
                    statement.setFloat(4, nota1);
                    statement.setFloat(5, nota2);
                    int rowsUpdated = statement.executeUpdate();

                    if (rowsUpdated > 0) {
                        System.out.println("Se ingreso el registro exitosamente");
                    }

                } catch (Exception exception) {
                    System.out.println("Error: " + exception.getMessage());
                }
            } else if (opcion == 2) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM calificaciones");

                    int id;
                    String nombre;
                    int cedula;
                    float nota1;
                    float nota2;

                    while(rs.next()){
                        id = rs.getInt("id");
                        nombre = rs.getString("nombre");
                        cedula = rs.getInt("cedula");
                        nota1 = rs.getFloat("calificacion1");
                        nota2 = rs.getFloat("calificacion2");

                        System.out.println(id + " " + nombre + " " + cedula + " " + nota1 + " " + nota2);
                    }

                }catch(Exception exception){
                    System.out.println("Error: " + exception.getMessage());
                }
            } else if (opcion == 3) {
                int opcion2;
                do {
                    System.out.println("Actualizacion de los datos");
                    System.out.println("1. Cambiar el Nombre del estudiante");
                    System.out.println("2. Cambiar el Cédula del estudiante");
                    System.out.println("3. Cambiar la primera calificacion del estudiante");
                    System.out.println("4. Cambiar la segunda calificacion del estudiante");
                    System.out.println("5. Salir");

                    System.out.print("Seleccione una opción: ");
                    opcion2 = scanner.nextInt();

                    if (opcion2 == 1) {
                        try {
                            int id;
                            String nombre;
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                            String sql = "UPDATE calificaciones SET nombre=? where id=?";
                            PreparedStatement statement = conn.prepareStatement(sql);
                            System.out.println("Ingrese el id del estudiante: ");
                            id = scanner.nextInt();
                            System.out.println("Ingrese el nuevo nombre del estudiante: ");
                            nombre = scanner.next();

                            statement.setString(1, nombre);
                            statement.setInt(2, id);

                            int rowsUpdated = statement.executeUpdate();

                            if (rowsUpdated > 0) {
                                System.out.println("Se actualizo el registro exitosamente");
                            }

                        } catch (Exception exception) {
                            System.out.println("Error: " + exception.getMessage());
                        }
                    } else if (opcion2 == 2) {
                        try {
                            int id;
                            int cedula;
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                            String sql = "UPDATE calificaciones SET cedula=? where id=?";
                            PreparedStatement statement = conn.prepareStatement(sql);

                            System.out.println("Ingrese el id del estudiante: ");
                            id = scanner.nextInt();
                            System.out.println("Ingrese la nueva cedula del estudiante: ");
                            cedula = scanner.nextInt();
                            statement.setInt(1, cedula);
                            statement.setInt(2, id);

                            int rowsUpdated = statement.executeUpdate();

                            if (rowsUpdated > 0) {
                                System.out.println("Se actualizo el registro exitosamente");
                            }

                        } catch (Exception exception) {
                            System.out.println("Error: " + exception.getMessage());
                        }
                    } else if (opcion2 == 3) {
                        try {
                            int id;
                            float nota1;
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                            String sql = "UPDATE calificaciones SET nota1=? where id=?";
                            PreparedStatement statement = conn.prepareStatement(sql);

                            System.out.println("Ingrese el id del estudiante: ");
                            id = scanner.nextInt();
                            System.out.println("Ingrese la nueva calificación1 del estudiante: ");
                            nota1 = scanner.nextFloat();

                            statement.setFloat(1, nota1);
                            statement.setInt(2, id);

                            int rowsUpdated = statement.executeUpdate();

                            if (rowsUpdated > 0) {
                                System.out.println("Se actualizo el registro exitosamente");
                            }

                        } catch (Exception exception) {
                            System.out.println("Error: " + exception.getMessage());
                        }

                    } else if (opcion2 == 4) {
                        try {
                            int id;
                            float nota2;
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                            String sql = "UPDATE calificaciones SET nota2=? where id=?";
                            PreparedStatement statement = conn.prepareStatement(sql);

                            System.out.println("Ingrese el id del estudiante: ");
                            id = scanner.nextInt();
                            System.out.println("Ingrese la nueva calificación2 del estudiante: ");
                            nota2 = scanner.nextFloat();

                            statement.setFloat(1, nota2);
                            statement.setInt(2, id);

                            int rowsUpdated = statement.executeUpdate();

                            if (rowsUpdated > 0) {
                                System.out.println("Se actualizo el registro exitosamente");
                            }

                        } catch (Exception exception) {
                            System.out.println("Error: " + exception.getMessage());
                        }

                    }
                    if (opcion2 >= 5) {
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    }
                } while (opcion2 != 5);
            } else if (opcion == 4) {
                try {
                    int id;
                    String conf;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                    String sql = "DELETE FROM calificaciones WHERE id=?";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    System.out.println("Ingrese el id del estudiante: ");
                    id = scanner.nextInt();
                    System.out.println("Esta seguro de eliminar el registro?");
                    System.out.print("Ingrese si o no: ");
                    conf=scanner.next();
                    if(conf.equals("si")) {

                        statement.setInt(1, id);

                        int rowsUpdated = statement.executeUpdate();

                        if (rowsUpdated > 0) {
                            System.out.println("Se elimino el registro exitosamente");
                        }
                    }
                } catch (Exception exception) {
                    System.out.println("Error: " + exception.getMessage());
                }

            } else if (opcion == 5) {
                System.out.println("Bye Bye que tenga un lindo dia.");
            } else {
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        } while (opcion != 5);
    }
}