package co.samtel.usuario.controller;

import co.samtel.usuario.gen.contract.V1UsuarioApi;
import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.type.UsuarioTypeResponse;
import co.samtel.usuario.service.impl.UsuarioServiceImpl;
import co.samtel.usuario.utils.exeption.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;
import static co.samtel.usuario.constant.Constant.ERROR_SERVICIO;

public class UsuarioController implements V1UsuarioApi {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

    @Inject
    UsuarioServiceImpl usuarioServiceImpl;

    @Override
    public Response createUser(UsuarioTypeInput usuarioTypeInput){
        LOG.info("Inicia crearUsuario Controller");
        UsuarioTypeResponse response;
        try {
            response =usuarioServiceImpl.createUser(usuarioTypeInput);
        }catch (ApplicationException e) {
            LOG.error("Se identifica error " + e.getMessage() + " createUser Controller");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
        LOG.info("Finaliza crearUsuario Controller  ");
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @Override
    public Response updateUser(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia proceso actualización updateUser Controller");
        try {
            usuarioServiceImpl.updateUser(idtblUser, usuarioTypeInput);

        } catch (Exception e) {
            LOG.error(ERROR_SERVICIO + e.getMessage() + " updateUser Controller");
            throw new RuntimeException(e);
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(usuarioTypeInput).build();
    }

    @Override
    public Response deleteUser(Integer idtblUser) {
        LOG.info("Inicio el proceso eliminarUsuario Controller.");
        try{
            usuarioServiceImpl.deleteUser(idtblUser);
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " eliminarUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.noContent().build();
    }

    @Override
    public Response getAllUser() {
        LOG.info("Inicio el proceso listarTodosLosUsuarios Controller.");
        List<UsuarioTypeResponse> reponses = null;
        try{
            reponses = usuarioServiceImpl.getUsersList();
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " listarTodosLosUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).entity(reponses).build();
        }
        return Response.status(Response.Status.FOUND).entity(reponses).build();
    }

    @Override
    public Response getUser(Integer idtblUser) {

        LOG.info("Inicio el proceso de listarUsuario Controller.");

        UsuarioTypeResponse response = null;

        try{
            response = usuarioServiceImpl.getUser(idtblUser);
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage()+ " listarUsuario Controller.");
            return  Response.status(Response.Status.BAD_REQUEST).entity(response).build();
        }

        return Response.status(Response.Status.FOUND).entity(response).build();
    }



}

