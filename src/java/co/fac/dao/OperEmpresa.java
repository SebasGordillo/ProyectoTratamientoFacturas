package co.fac.dao;

import co.fac.dto.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteban Moreno
 */
public class OperEmpresa implements Operaciones {
//    private static final Logger LOG = LogManager.getLogger(OperEmpresa.class);

    public int insertar(Empresa empresa) {
        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        if (miconec != null) {
            try {
                PreparedStatement ps = miconec.prepareStatement("INSERT INTO public.empresas(\n"
                        + "	usuario, contrasena, \"direccion \", \"  telefono\", \" nit\")\n"
                        + "	VALUES (?, ?, ?, ?, ?)");
                ps.setString(1, empresa.getUsuario());
                ps.setString(2, empresa.getContrasena());
                ps.setString(3, empresa.getDireccion());
                ps.setInt(4, empresa.getTelefono());
                ps.setInt(5, empresa.getNit());
                int rta = ps.executeUpdate();
                return rta;

            } catch (SQLException ex) {
                Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al insertar vehiculo", ex);
            } finally {
                conn.cerrarConnexion(miconec);
            }
        }
        return 0;
    }

    public int actualizar(Empresa empresa) {
         AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        if (miconec != null) {
            try {
                PreparedStatement ps = miconec.prepareStatement("UPDATE public.empresas SET usuario=?, contrasena=?, \"direccion \"=?, \"  telefono\"=?, \" nit\"=? WHERE usuario=?");
                ps.setString(1, empresa.getUsuario());
                ps.setString(2, empresa.getContrasena());
                ps.setString(3, empresa.getDireccion());
                ps.setInt(4, empresa.getTelefono());
                ps.setInt(5, empresa.getNit());

                int rta = ps.executeUpdate(); 
                return rta;

            } catch (SQLException ex) {
                Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al actualizar vehiculo", ex);
            } finally {
               conn.cerrarConnexion(miconec);
            }
        }

        return 0;
       
    }

    public int borrar(Empresa empresa) {
        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        if (miconec != null) {
            try {
                PreparedStatement ps = miconec.prepareStatement("DELETE FROM public.empresas WHERE usuario=?");
                ps.setString(1, empresa.getUsuario());

                int rta = ps.executeUpdate();
                return rta;

            } catch (SQLException ex) {
                Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al borrar ", ex);
            } finally {
                conn.cerrarConnexion(miconec);
            }
        }

        return 0;
    }

    public List<Empresa> Listar() {
        List<Empresa> lista = new ArrayList<>();
        AdmonConexion conn = new AdmonConexion();
        Connection miconec = conn.getConnection();
        if (miconec != null) {

            PreparedStatement ps;
            try {
                ps = miconec.prepareStatement("SELECT usuario, contrasena, \"direccion \", \"  telefono\", \" nit\"\n" +
"	FROM public.empresas");

                ResultSet results = ps.executeQuery();
                
                while (results.next()) {

                    lista.add(new Empresa(results.getString(1), results.getString(2), results.getString(3), results.getInt(4), results.getInt(5)));
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperEmpresa.class.getName()).log(Level.SEVERE, "Error al listar empresa", ex);
            } finally {
                conn.cerrarConnexion(miconec);
            }
        }
        return lista;

    }
}

