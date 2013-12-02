package oo.coupling;

import java.util.List;

public interface CustomerMessageDao {

    void addMessage(long customerId, String body);

    List<String> findAllMessages(long customerId);

}
