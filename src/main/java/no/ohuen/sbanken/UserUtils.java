package no.ohuen.sbanken;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import no.ohuen.sbanken.api.v1.auth.Token;

/**
 *
 * @author Timur Samkharadze
 */
public final class UserUtils {

    public static final boolean prepareUserSession(HttpSession session) {
        if (!UserUtils.isTokenExist(session)) {
            return false;
        }
        List<Task> kidsTask = new ArrayList<>();
        return true;
    }

    private static boolean isTokenExist(HttpSession session) {
        //FIXME
        Token token = (Token) session.getAttribute("access_token");
        return true;
    }
}
