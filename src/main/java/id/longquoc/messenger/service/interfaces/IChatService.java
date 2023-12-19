package id.longquoc.messenger.service.interfaces;

import id.longquoc.messenger.dto.chat.ConversationDto;
import id.longquoc.messenger.dto.chat.MessageDto;
import id.longquoc.messenger.dto.chat.PrevMessageDto;
import id.longquoc.messenger.dto.user.OnlineUserDto;
import id.longquoc.messenger.dto.user.UserStateDto;
import id.longquoc.messenger.model.User;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;

import java.util.List;
import java.util.UUID;

public interface IChatService {
    void submitMessage(MessageDto messageDto, StompHeaderAccessor accessor);
    List<OnlineUserDto> fetchOnlineUsers();

    List<ConversationDto> fetchConversations(String name);
    void createAndSendConversation(User[] users, StompHeaderAccessor accessor);
    void changeUserState(UserStateDto userStateDto, String username);
    MessageDto saveOrUpdateMessage(User[] users, MessageDto message);
    PrevMessageDto fetchPreviousChat(UUID conversationId, int page, String currentUser);


}
