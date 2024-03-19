package co.samtel.usuario.gen.contract;

import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.type.UsuarioTypeResponse;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-19T10:08:45.190332700-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public interface V1UsuarioApi {

    @POST
    @Path("/usuario")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response createUser(@Valid UsuarioTypeInput usuarioTypeInput);

    @DELETE
    @Path("/eliminarUsuario/{idtbl_user}")
    Response deleteUser(@PathParam("idtbl_user") @Min(1) Integer idtblUser);

    @GET
    @Path("/listarTodo")
    @Produces({ "application/json" })
    Response getAllUser();

    @GET
    @Path("/listUsuario/{idtbl_user}")
    @Produces({ "application/json" })
    Response getUser(@PathParam("idtbl_user") @Min(1) Integer idtblUser);

    @PUT
    @Path("/editarUsuario/{idtbl_user}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updateUser(@PathParam("idtbl_user") @Min(1) Integer idtblUser,@Valid UsuarioTypeInput usuarioTypeInput);
}
