import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

    // Consultar todos los usuarios
    public List<Usuario> listarUsuarios() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery("FROM Usuario", Usuario.class)
                    .getResultList();

        } catch (Exception e) {
            System.out.println("Error al consultar usuarios: " + e.getMessage());
            return List.of();
        }
    }

    // Registrar un nuevo usuario
    public void registrarUsuario(String nombre, String correo, String telefono) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Usuario usuario = new Usuario(nombre, correo, telefono);

            session.persist(usuario);

            transaction.commit();

            System.out.println("Usuario registrado correctamente.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    // Actualizar un usuario
    public void actualizarUsuario(
            int id,
            String nombre,
            String correo,
            String telefono) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Usuario usuario = session.get(Usuario.class, id);

            if (usuario != null) {

                usuario.setNombre(nombre);
                usuario.setCorreo(correo);
                usuario.setTelefono(telefono);

                session.merge(usuario);

                transaction.commit();

                System.out.println("Usuario actualizado correctamente.");

            } else {

                System.out.println("No se encontró el usuario.");
                transaction.rollback();
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    // Eliminar un usuario
    public void eliminarUsuario(int id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Usuario usuario = session.get(Usuario.class, id);

            if (usuario != null) {

                session.remove(usuario);

                transaction.commit();

                System.out.println("Usuario eliminado correctamente.");

            } else {

                System.out.println("No se encontró el usuario.");
                transaction.rollback();
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}