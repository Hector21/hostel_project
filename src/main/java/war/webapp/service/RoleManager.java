package war.webapp.service;

import java.util.List;

import war.webapp.model.Role;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 */
public interface RoleManager extends GenericManager<Role, Long> {
    /**
     * {@inheritDoc}
     */
    List<Role> getRoles(Role role);

    /**
     * {@inheritDoc}
     */
    Role getRole(String rolename);

    /**
     * {@inheritDoc}
     */
    Role saveRole(Role role);

    /**
     * {@inheritDoc}
     */
    void removeRole(String rolename);
}
