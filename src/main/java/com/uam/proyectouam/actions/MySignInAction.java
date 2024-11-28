package com.uam.proyectouam.action;

import com.openxava.naviox.Modules;
import com.openxava.naviox.actions.ForwardToOriginalURIBaseAction;
import com.uam.proyectouam.model.Usuario;
import org.openxava.jpa.XPersistence;
import org.openxava.util.Is;
import org.openxava.util.Users;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MySignInAction extends ForwardToOriginalURIBaseAction {

    @Override
    public void execute() throws Exception {
        if (getErrors().contains()) return;
        String userName = getView().getValueString("user");
        String password = getView().getValueString("password");
        if (Is.emptyString(userName,password)) {
            addError("unauthorized_user");
            return;
        }
        TypedQuery<Usuario> query = XPersistence.getManager()
                .createNamedQuery("Usuario.findPassword", Usuario.class);
        query.setParameter(1, userName);
        query.setParameter(2, password);
        List<Usuario> lista = query.getResultList();
        if (lista == null || lista.isEmpty() || lista.get(0) == null) {
            addError("unauthorized_user");
            return;
        }
        HttpSession session = getRequest().getSession();
        session.setAttribute("naviox.user", userName);
        Modules modules = (Modules) session.getAttribute("modules");
        Users.setCurrent(userName);
        modules.reset();
        getView().reset();
        getContext().resetAllModulesExceptCurrent(getRequest());
        forwardToOriginalURI();
    }
}
