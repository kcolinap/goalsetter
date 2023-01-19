package backend.dto;

public class Login {

    private String token;
    private String refreshToken;
    private String refreshTokenExpiration;

    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getRefreshTokenExpiration() {
        return refreshTokenExpiration;
    }
}
