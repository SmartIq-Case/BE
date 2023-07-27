package com.smartIq.vehicledealership.vehicledealership.common.authorizationChecker;

import java.io.Serial;

/**
 * Endpointlere istek yapan kullanıcının ilgili işlem için yetkisi yoksa bu custom exception fırlatılır.
 *
 */
public class UnauthorizedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -4141410100L;

    private static final String DEFAULT_MESSAGE =
            "Unauthorized Request!";

    public UnauthorizedException(){
        super(DEFAULT_MESSAGE);
    }

}
