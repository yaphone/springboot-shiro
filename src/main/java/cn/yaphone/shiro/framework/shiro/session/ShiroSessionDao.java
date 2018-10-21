package cn.yaphone.shiro.framework.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.SessionDAO;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/21 15:23
 */
public class ShiroSessionDao implements SessionDAO {

    @Override
    public Serializable create(Session session) {
        return null;
    }

    @Override
    public Session readSession(Serializable serializable) throws UnknownSessionException {
        return null;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {

    }

    @Override
    public void delete(Session session) {

    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }
}
