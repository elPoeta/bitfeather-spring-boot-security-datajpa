
package io.elpoeta.bitfeather.service;

import io.elpoeta.bitfeather.domain.User;

/**
 *
 * @author elpoeta
 */
public interface UserService {
    User insertarUser(User user);
    User buscarPorEmail(String email);
}
