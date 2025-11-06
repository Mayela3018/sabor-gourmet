package com.maye.restaurante_app.aspect;

import com.maye.restaurante_app.model.Bitacora;
import com.maye.restaurante_app.model.Mesa;
import com.maye.restaurante_app.repository.BitacoraRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AuditoriaAspect {

    @Autowired
    private BitacoraRepository bitacoraRepo;

    /**
     * Obtiene el nombre del usuario autenticado actual.
     * Si no hay usuario, devuelve "SYSTEM".
     */
    private String obtenerUsuarioActual() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (auth != null && auth.isAuthenticated()) ? auth.getName() : "SYSTEM";
    }

    /**
     * Audita las operaciones de guardar (crear o actualizar) mesas.
     */
    @AfterReturning("execution(* com.maye.restaurante_app.service.MesaService.guardar(..))")
    public void auditarGuardar(JoinPoint jp) {
        Mesa mesa = (Mesa) jp.getArgs()[0];
        boolean esNuevo = mesa.getIdMesa() == null;

        Bitacora b = new Bitacora();
        b.setAccion(esNuevo ? "CREAR" : "ACTUALIZAR");
        b.setEntidad("Mesa");
        b.setUsuario(obtenerUsuarioActual());
        b.setFechaHora(LocalDateTime.now());
        bitacoraRepo.save(b);
    }

    /**
     * Audita la eliminación de mesas.
     */
    @AfterReturning("execution(* com.maye.restaurante_app.service.MesaService.eliminar(..))")
    public void auditarEliminar(JoinPoint jp) {
        Bitacora b = new Bitacora();
        b.setAccion("ELIMINAR");
        b.setEntidad("Mesa");
        b.setUsuario(obtenerUsuarioActual());
        b.setFechaHora(LocalDateTime.now());
        bitacoraRepo.save(b);
    }

    /**
     * Audita cuando se ocupa una mesa.
     */
    @AfterReturning("execution(* com.maye.restaurante_app.service.MesaService.ocuparMesa(..))")
    public void auditarOcupar(JoinPoint jp) {
        registrarCambioEstado("OCUPAR");
    }

    /**
     * Audita cuando se libera una mesa.
     */
    @AfterReturning("execution(* com.maye.restaurante_app.service.MesaService.liberarMesa(..))")
    public void auditarLiberar(JoinPoint jp) {
        registrarCambioEstado("LIBERAR");
    }

    /**
     * Método auxiliar para registrar cambios de estado.
     */
    private void registrarCambioEstado(String accion) {
        Bitacora b = new Bitacora();
        b.setAccion(accion);
        b.setEntidad("Mesa");
        b.setUsuario(obtenerUsuarioActual());
        b.setFechaHora(LocalDateTime.now());
        bitacoraRepo.save(b);
    }
}