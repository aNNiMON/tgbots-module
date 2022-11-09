package com.annimon.tgbotsmodule.api.methods;

import com.annimon.tgbotsmodule.api.methods.administration.*;
import com.annimon.tgbotsmodule.api.methods.answerqueries.*;
import com.annimon.tgbotsmodule.api.methods.forum.*;
import com.annimon.tgbotsmodule.api.methods.games.*;
import com.annimon.tgbotsmodule.api.methods.info.*;
import com.annimon.tgbotsmodule.api.methods.invoices.CreateInvoiceLinkMethod;
import com.annimon.tgbotsmodule.api.methods.invoices.SendInvoiceMethod;
import com.annimon.tgbotsmodule.api.methods.other.*;
import com.annimon.tgbotsmodule.api.methods.polls.SendPollMethod;
import com.annimon.tgbotsmodule.api.methods.polls.StopPollMethod;
import com.annimon.tgbotsmodule.api.methods.send.*;
import com.annimon.tgbotsmodule.api.methods.stickers.*;
import com.annimon.tgbotsmodule.api.methods.updates.*;
import com.annimon.tgbotsmodule.api.methods.updatingmessages.*;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.polls.StopPoll;
import org.telegram.telegrambots.meta.api.objects.ChatPermissions;
import org.telegram.telegrambots.meta.api.objects.adminrights.ChatAdministratorRights;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.passport.dataerror.PassportElementError;

@SuppressWarnings("unused")
public final class Methods {

    private Methods() { }

    public static final class Administration {
        private Administration() { }

        public static ApproveChatJoinRequestMethod approveChatJoinRequest() {
            return new ApproveChatJoinRequestMethod();
        }

        public static ApproveChatJoinRequestMethod approveChatJoinRequest(@NotNull String chatId, long userId) {
            return new ApproveChatJoinRequestMethod().setChatId(chatId).setUserId(userId);
        }

        public static ApproveChatJoinRequestMethod approveChatJoinRequest(long chatId, long userId) {
            return new ApproveChatJoinRequestMethod().setChatId(chatId).setUserId(userId);
        }


        public static CreateChatInviteLinkMethod createChatInviteLink() {
            return new CreateChatInviteLinkMethod();
        }

        public static CreateChatInviteLinkMethod createChatInviteLink(@NotNull String chatId) {
            return new CreateChatInviteLinkMethod().setChatId(chatId);
        }

        public static CreateChatInviteLinkMethod createChatInviteLink(long chatId) {
            return new CreateChatInviteLinkMethod().setChatId(chatId);
        }


        public static DeclineChatJoinRequestMethod declineChatJoinRequest() {
            return new DeclineChatJoinRequestMethod();
        }

        public static DeclineChatJoinRequestMethod declineChatJoinRequest(@NotNull String chatId, long userId) {
            return new DeclineChatJoinRequestMethod().setChatId(chatId).setUserId(userId);
        }

        public static DeclineChatJoinRequestMethod declineChatJoinRequest(long chatId, long userId) {
            return new DeclineChatJoinRequestMethod().setChatId(chatId).setUserId(userId);
        }


        public static DeleteChatPhotoMethod deleteChatPhoto() {
            return new DeleteChatPhotoMethod();
        }

        public static DeleteChatPhotoMethod deleteChatPhoto(@NotNull String chatId) {
            return new DeleteChatPhotoMethod().setChatId(chatId);
        }

        public static DeleteChatPhotoMethod deleteChatPhoto(long chatId) {
            return new DeleteChatPhotoMethod().setChatId(chatId);
        }


        public static DeleteChatStickerSetMethod deleteChatStickerSet() {
            return new DeleteChatStickerSetMethod();
        }

        public static DeleteChatStickerSetMethod deleteChatStickerSet(@NotNull String chatId) {
            return new DeleteChatStickerSetMethod().setChatId(chatId);
        }

        public static DeleteChatStickerSetMethod deleteChatStickerSet(long chatId) {
            return new DeleteChatStickerSetMethod().setChatId(chatId);
        }


        public static EditChatInviteLinkMethod editChatInviteLink() {
            return new EditChatInviteLinkMethod();
        }

        public static EditChatInviteLinkMethod editChatInviteLink(@NotNull String chatId, String inviteLink) {
            return new EditChatInviteLinkMethod().setChatId(chatId).setInviteLink(inviteLink);
        }

        public static EditChatInviteLinkMethod editChatInviteLink(long chatId, String inviteLink) {
            return new EditChatInviteLinkMethod().setChatId(chatId).setInviteLink(inviteLink);
        }


        public static ExportChatInviteLinkMethod exportChatInviteLink() {
            return new ExportChatInviteLinkMethod();
        }

        public static ExportChatInviteLinkMethod exportChatInviteLink(@NotNull String chatId) {
            return new ExportChatInviteLinkMethod().setChatId(chatId);
        }

        public static ExportChatInviteLinkMethod exportChatInviteLink(long chatId) {
            return new ExportChatInviteLinkMethod().setChatId(chatId);
        }


        public static BanChatMemberMethod banChatMember() {
            return new BanChatMemberMethod();
        }

        public static BanChatMemberMethod banChatMember(@NotNull String chatId, long userId) {
            return new BanChatMemberMethod().setChatId(chatId).setUserId(userId);
        }

        public static BanChatMemberMethod banChatMember(long chatId, long userId) {
            return new BanChatMemberMethod().setChatId(chatId).setUserId(userId);
        }


        public static BanChatSenderChatMethod banChatSenderChat() {
            return new BanChatSenderChatMethod();
        }

        public static BanChatSenderChatMethod banChatSenderChat(@NotNull String chatId, long senderChatId) {
            return new BanChatSenderChatMethod().setChatId(chatId).setSenderChatId(senderChatId);
        }

        public static BanChatSenderChatMethod banChatSenderChat(long chatId, long senderChatId) {
            return new BanChatSenderChatMethod().setChatId(chatId).setSenderChatId(senderChatId);
        }


        public static PinChatMessageMethod pinChatMessage() {
            return new PinChatMessageMethod();
        }

        public static PinChatMessageMethod pinChatMessage(@NotNull String chatId, int messageId) {
            return new PinChatMessageMethod().setChatId(chatId).setMessageId(messageId);
        }

        public static PinChatMessageMethod pinChatMessage(long chatId, int messageId) {
            return new PinChatMessageMethod().setChatId(chatId).setMessageId(messageId);
        }


        public static PromoteChatMemberMethod promoteChatMember() {
            return new PromoteChatMemberMethod();
        }

        public static PromoteChatMemberMethod promoteChatMember(@NotNull String chatId, long userId) {
            return new PromoteChatMemberMethod().setChatId(chatId).setUserId(userId);
        }

        public static PromoteChatMemberMethod promoteChatMember(long chatId, long userId) {
            return new PromoteChatMemberMethod().setChatId(chatId).setUserId(userId);
        }


        public static RestrictChatMemberMethod restrictChatMember() {
            return new RestrictChatMemberMethod();
        }

        public static RestrictChatMemberMethod restrictChatMember(@NotNull String chatId, long userId) {
            return new RestrictChatMemberMethod().setChatId(chatId).setUserId(userId);
        }

        public static RestrictChatMemberMethod restrictChatMember(long chatId, long userId) {
            return new RestrictChatMemberMethod().setChatId(chatId).setUserId(userId);
        }


        public static RevokeChatInviteLinkMethod revokeChatInviteLink() {
            return new RevokeChatInviteLinkMethod();
        }

        public static RevokeChatInviteLinkMethod revokeChatInviteLink(@NotNull String chatId, String inviteLink) {
            return new RevokeChatInviteLinkMethod().setChatId(chatId).setInviteLink(inviteLink);
        }

        public static RevokeChatInviteLinkMethod revokeChatInviteLink(long chatId, String inviteLink) {
            return new RevokeChatInviteLinkMethod().setChatId(chatId).setInviteLink(inviteLink);
        }


        public static SetChatAdministratorCustomTitleMethod setChatAdministratorCustomTitle() {
            return new SetChatAdministratorCustomTitleMethod();
        }

        public static SetChatAdministratorCustomTitleMethod setChatAdministratorCustomTitle(@NotNull String chatId, long userId) {
            return new SetChatAdministratorCustomTitleMethod().setChatId(chatId).setUserId(userId);
        }

        public static SetChatAdministratorCustomTitleMethod setChatAdministratorCustomTitle(long chatId, long userId) {
            return new SetChatAdministratorCustomTitleMethod().setChatId(chatId).setUserId(userId);
        }


        public static SetChatDescriptionMethod setChatDescription() {
            return new SetChatDescriptionMethod();
        }

        public static SetChatDescriptionMethod setChatDescription(@NotNull String chatId, @NotNull String description) {
            return new SetChatDescriptionMethod().setChatId(chatId).setDescription(description);
        }

        public static SetChatDescriptionMethod setChatDescription(long chatId, @NotNull String description) {
            return new SetChatDescriptionMethod().setChatId(chatId).setDescription(description);
        }


        public static SetChatPermissionsMethod setChatPermissions() {
            return new SetChatPermissionsMethod();
        }

        public static SetChatPermissionsMethod setChatDescription(@NotNull String chatId, @NotNull ChatPermissions permissions) {
            return new SetChatPermissionsMethod().setChatId(chatId).setPermissions(permissions);
        }

        public static SetChatPermissionsMethod setChatDescription(long chatId, @NotNull ChatPermissions permissions) {
            return new SetChatPermissionsMethod().setChatId(chatId).setPermissions(permissions);
        }


        public static SetChatPhotoMethod setChatPhoto() {
            return new SetChatPhotoMethod();
        }

        public static SetChatPhotoMethod setChatPhoto(@NotNull String chatId) {
            return new SetChatPhotoMethod().setChatId(chatId);
        }

        public static SetChatPhotoMethod setChatPhoto(long chatId) {
            return new SetChatPhotoMethod().setChatId(chatId);
        }


        public static SetChatStickerSetMethod setChatStickerSet() {
            return new SetChatStickerSetMethod();
        }

        public static SetChatStickerSetMethod setChatStickerSet(@NotNull String chatId, @NotNull String stickerSetName) {
            return new SetChatStickerSetMethod().setChatId(chatId).setStickerSetName(stickerSetName);
        }

        public static SetChatStickerSetMethod setChatStickerSet(long chatId, @NotNull String stickerSetName) {
            return new SetChatStickerSetMethod().setChatId(chatId).setStickerSetName(stickerSetName);
        }


        public static SetChatTitleMethod setChatTitle() {
            return new SetChatTitleMethod();
        }

        public static SetChatTitleMethod setChatTitle(@NotNull String chatId, @NotNull String title) {
            return new SetChatTitleMethod().setChatId(chatId).setTitle(title);
        }

        public static SetChatTitleMethod setChatTitle(long chatId, @NotNull String title) {
            return new SetChatTitleMethod().setChatId(chatId).setTitle(title);
        }


        public static UnbanChatMemberMethod unbanChatMember() {
            return new UnbanChatMemberMethod();
        }

        public static UnbanChatMemberMethod unbanChatMember(@NotNull String chatId, long userId) {
            return new UnbanChatMemberMethod().setChatId(chatId).setUserId(userId);
        }

        public static UnbanChatMemberMethod unbanChatMember(long chatId, long userId) {
            return new UnbanChatMemberMethod().setChatId(chatId).setUserId(userId);
        }


        public static UnbanChatSenderChatMethod unbanChatSenderChat() {
            return new UnbanChatSenderChatMethod();
        }

        public static UnbanChatSenderChatMethod unbanChatSenderChat(@NotNull String chatId, long senderChatId) {
            return new UnbanChatSenderChatMethod().setChatId(chatId).setSenderChatId(senderChatId);
        }

        public static UnbanChatSenderChatMethod unbanChatSenderChat(long chatId, long senderChatId) {
            return new UnbanChatSenderChatMethod().setChatId(chatId).setSenderChatId(senderChatId);
        }


        public static UnpinChatMessageMethod unpinChatMessage() {
            return new UnpinChatMessageMethod();
        }

        public static UnpinChatMessageMethod unpinChatMessage(@NotNull String chatId) {
            return new UnpinChatMessageMethod().setChatId(chatId);
        }

        public static UnpinChatMessageMethod unpinChatMessage(long chatId) {
            return new UnpinChatMessageMethod().setChatId(chatId);
        }


        public static UnpinAllChatMessagesMethod unpinAllChatMessages() {
            return new UnpinAllChatMessagesMethod();
        }

        public static UnpinAllChatMessagesMethod unpinAllChatMessages(@NotNull String chatId) {
            return new UnpinAllChatMessagesMethod().setChatId(chatId);
        }

        public static UnpinAllChatMessagesMethod unpinAllChatMessages(long chatId) {
            return new UnpinAllChatMessagesMethod().setChatId(chatId);
        }
    }

    public static class Forum {
        private Forum() { }

        public static CreateForumTopicMethod createForumTopic() {
            return new CreateForumTopicMethod();
        }

        public static CreateForumTopicMethod createForumTopic(@NotNull String chatId) {
            return new CreateForumTopicMethod().setChatId(chatId);
        }

        public static CreateForumTopicMethod createForumTopic(long chatId) {
            return new CreateForumTopicMethod().setChatId(chatId);
        }


        public static EditForumTopicMethod editForumTopic() {
            return new EditForumTopicMethod();
        }

        public static EditForumTopicMethod editForumTopic(@NotNull String chatId, int messageThreadId) {
            return new EditForumTopicMethod().setChatId(chatId).setMessageThreadId(messageThreadId);
        }

        public static EditForumTopicMethod editForumTopic(long chatId, int messageThreadId) {
            return new EditForumTopicMethod().setChatId(chatId).setMessageThreadId(messageThreadId);
        }


        public static CloseForumTopicMethod closeForumTopic() {
            return new CloseForumTopicMethod();
        }

        public static CloseForumTopicMethod closeForumTopic(@NotNull String chatId, int messageThreadId) {
            return new CloseForumTopicMethod().setChatId(chatId).setMessageThreadId(messageThreadId);
        }

        public static CloseForumTopicMethod closeForumTopic(long chatId, int messageThreadId) {
            return new CloseForumTopicMethod().setChatId(chatId).setMessageThreadId(messageThreadId);
        }


        public static ReopenForumTopicMethod reopenForumTopic() {
            return new ReopenForumTopicMethod();
        }

        public static ReopenForumTopicMethod reopenForumTopic(@NotNull String chatId, int messageThreadId) {
            return new ReopenForumTopicMethod().setChatId(chatId).setMessageThreadId(messageThreadId);
        }

        public static ReopenForumTopicMethod reopenForumTopic(long chatId, int messageThreadId) {
            return new ReopenForumTopicMethod().setChatId(chatId).setMessageThreadId(messageThreadId);
        }


        public static DeleteForumTopicMethod deleteForumTopic() {
            return new DeleteForumTopicMethod();
        }

        public static DeleteForumTopicMethod deleteForumTopic(@NotNull String chatId, int messageThreadId) {
            return new DeleteForumTopicMethod().setChatId(chatId).setMessageThreadId(messageThreadId);
        }

        public static DeleteForumTopicMethod deleteForumTopic(long chatId, int messageThreadId) {
            return new DeleteForumTopicMethod().setChatId(chatId).setMessageThreadId(messageThreadId);
        }


        public static GetForumTopicIconStickersMethod getForumTopicIconStickers() {
            return new GetForumTopicIconStickersMethod();
        }


        public static UnpinAllForumTopicMessagesMethod unpinAllForumTopicMessages() {
            return new UnpinAllForumTopicMessagesMethod();
        }

        public static UnpinAllForumTopicMessagesMethod unpinAllForumTopicMessages(@NotNull String chatId) {
            return new UnpinAllForumTopicMessagesMethod().setChatId(chatId);
        }

        public static UnpinAllForumTopicMessagesMethod unpinAllForumTopicMessages(long chatId) {
            return new UnpinAllForumTopicMessagesMethod().setChatId(chatId);
        }
    }

    public static class Games {
        private Games() { }

        public static SendGameMethod sendGame() {
            return new SendGameMethod();
        }

        public static SendGameMethod sendGame(@NotNull String chatId, @NotNull String gameShortName) {
            return new SendGameMethod().setChatId(chatId).setGameShortName(gameShortName);
        }

        public static SendGameMethod sendGame(long chatId, @NotNull String gameShortName) {
            return new SendGameMethod().setChatId(chatId).setGameShortName(gameShortName);
        }


        public static GetGameHighScoresMethod getGameHighScores() {
            return new GetGameHighScoresMethod();
        }


        public static SetGameScoreMethod setGameScore() {
            return new SetGameScoreMethod();
        }
    }

    public static class Passport {
        private Passport() { }

        public static SetPassportDataErrorsMethod setPassportDataErrors() {
            return new SetPassportDataErrorsMethod();
        }

        public static SetPassportDataErrorsMethod setPassportDataErrors(long userId) {
            return new SetPassportDataErrorsMethod().setUserId(userId);
        }

        public static SetPassportDataErrorsMethod setPassportDataErrors(long userId, @NotNull List<PassportElementError> errors) {
            return new SetPassportDataErrorsMethod().setUserId(userId).setErrors(errors);
        }
    }

    public static class Payments {
        private Payments() { }

        public static SendInvoiceMethod sendInvoice() {
            return new SendInvoiceMethod();
        }

        public static SendInvoiceMethod sendInvoice(@NotNull String chatId) {
            return new SendInvoiceMethod().setChatId(chatId);
        }

        public static SendInvoiceMethod sendInvoice(long chatId) {
            return new SendInvoiceMethod().setChatId(chatId);
        }


        public static CreateInvoiceLinkMethod createInvoiceLink() {
            return new CreateInvoiceLinkMethod();
        }


        public static AnswerShippingQueryMethod answerShippingQuery() {
            return new AnswerShippingQueryMethod();
        }

        public static AnswerShippingQueryMethod answerShippingQuery(@NotNull String shippingQueryId, boolean ok) {
            return new AnswerShippingQueryMethod().setShippingQueryId(shippingQueryId).setOk(ok);
        }


        public static AnswerPreCheckoutQueryMethod answerPreCheckoutQuery() {
            return new AnswerPreCheckoutQueryMethod();
        }

        public static AnswerPreCheckoutQueryMethod answerPreCheckoutQuery(@NotNull String preCheckoutQueryId, boolean ok) {
            return new AnswerPreCheckoutQueryMethod().setPreCheckoutQueryId(preCheckoutQueryId).setOk(ok);
        }
    }

    public static class Polls {
        private Polls() { }

        public static SendPollMethod sendPoll() {
            return new SendPollMethod();
        }

        public static SendPollMethod sendPoll(@NotNull String chatId) {
            return sendPoll().setChatId(chatId);
        }

        public static SendPollMethod sendPoll(long chatId) {
            return sendPoll().setChatId(chatId);
        }


        public static StopPollMethod stopPoll() {
            return new StopPollMethod();
        }

        public static StopPollMethod stopPoll(@NotNull String chatId, int messageId) {
            return new StopPollMethod(new StopPoll(chatId, messageId));
        }

        public static StopPollMethod stopPoll(long chatId, int messageId) {
            return stopPoll(Long.toString(chatId), messageId);
        }
    }

    public static class Stickers {
        private Stickers() { }

        public static AddStickerToSetMethod addStickerToSet() {
            return new AddStickerToSetMethod();
        }

        public static AddStickerToSetMethod addStickerToSet(long userId, @NotNull String name, @NotNull String emojis) {
            return new AddStickerToSetMethod().setUserId(userId).setName(name).setEmojis(emojis);
        }

        public static AddAnimatedStickerToSetMethod addAnimatedStickerToSet() {
            return new AddAnimatedStickerToSetMethod();
        }

        public static AddAnimatedStickerToSetMethod addAnimatedStickerToSet(long userId, @NotNull String name, @NotNull String emojis) {
            return new AddAnimatedStickerToSetMethod().setUserId(userId).setName(name).setEmojis(emojis);
        }

        public static AddWebmStickerToSetMethod addWebmStickerToSet() {
            return new AddWebmStickerToSetMethod();
        }

        public static AddWebmStickerToSetMethod addWebmStickerToSet(long userId, @NotNull String name, @NotNull String emojis) {
            return new AddWebmStickerToSetMethod().setUserId(userId).setName(name).setEmojis(emojis);
        }


        public static CreateNewStickerSetMethod createNewStickerSet() {
            return new CreateNewStickerSetMethod();
        }

        public static CreateNewStickerSetMethod createNewStickerSet(
                long userId, @NotNull String name,
                @NotNull String title, @NotNull String emojis) {
            return new CreateNewStickerSetMethod().setUserId(userId).setName(name).setTitle(title).setEmojis(emojis);
        }

        public static CreateNewAnimatedStickerSetMethod createNewAnimatedStickerSet() {
            return new CreateNewAnimatedStickerSetMethod();
        }

        public static CreateNewAnimatedStickerSetMethod createNewAnimatedStickerSet(
                long userId, @NotNull String name,
                @NotNull String title, @NotNull String emojis) {
            return new CreateNewAnimatedStickerSetMethod().setUserId(userId).setName(name).setTitle(title).setEmojis(emojis);
        }

        public static CreateNewWebmStickerSetMethod createNewWebmStickerSet() {
            return new CreateNewWebmStickerSetMethod();
        }

        public static CreateNewWebmStickerSetMethod createNewWebmStickerSet(
                long userId, @NotNull String name,
                @NotNull String title, @NotNull String emojis) {
            return new CreateNewWebmStickerSetMethod().setUserId(userId).setName(name).setTitle(title).setEmojis(emojis);
        }


        public static DeleteStickerFromSetMethod deleteStickerFromSet() {
            return new DeleteStickerFromSetMethod();
        }

        public static DeleteStickerFromSetMethod deleteStickerFromSet(@NotNull String sticker) {
            return new DeleteStickerFromSetMethod().setSticker(sticker);
        }


        public static GetStickerSetMethod getStickerSet() {
            return new GetStickerSetMethod();
        }

        public static GetStickerSetMethod getStickerSet(@NotNull String name) {
            return new GetStickerSetMethod().setName(name);
        }


        public static SetStickerPositionInSetMethod setStickerPositionInSet() {
            return new SetStickerPositionInSetMethod();
        }

        public static SetStickerPositionInSetMethod setStickerPositionInSet(@NotNull String sticker, int position) {
            return new SetStickerPositionInSetMethod().setSticker(sticker).setPosition(position);
        }


        public static SetStickerSetThumbMethod setStickerSetThumb() {
            return new SetStickerSetThumbMethod();
        }

        public static SetStickerSetThumbMethod setStickerSetThumb(long userId) {
            return new SetStickerSetThumbMethod().setUserId(userId);
        }


        public static SendStickerMethod sendSticker() {
            return new SendStickerMethod();
        }

        public static SendStickerMethod sendSticker(@NotNull String chatId) {
            return new SendStickerMethod().setChatId(chatId);
        }

        public static SendStickerMethod sendSticker(long chatId) {
            return new SendStickerMethod().setChatId(chatId);
        }


        public static UploadStickerFileMethod uploadStickerFile() {
            return new UploadStickerFileMethod();
        }

        public static UploadStickerFileMethod uploadStickerFile(long userId) {
            return new UploadStickerFileMethod().setUserId(userId);
        }
    }

    public static class Updates {
        private Updates() { }

        public static DeleteWebhookMethod deleteWebhook() {
            return new DeleteWebhookMethod();
        }


        public static GetUpdatesMethod getUpdates() {
            return new GetUpdatesMethod();
        }


        public static GetWebhookInfoMethod getWebhookInfo() {
            return new GetWebhookInfoMethod();
        }
    }


    // Info

    public static GetChatAdministratorsMethod getChatAdministrators() {
        return new GetChatAdministratorsMethod();
    }

    public static GetChatAdministratorsMethod getChatAdministrators(@NotNull String chatId) {
        return new GetChatAdministratorsMethod().setChatId(chatId);
    }

    public static GetChatAdministratorsMethod getChatAdministrators(long chatId) {
        return new GetChatAdministratorsMethod().setChatId(chatId);
    }


    public static GetChatMemberMethod getChatMember() {
        return new GetChatMemberMethod();
    }

    public static GetChatMemberMethod getChatMember(@NotNull String chatId, long userId) {
        return new GetChatMemberMethod().setChatId(chatId).setUserId(userId);
    }

    public static GetChatMemberMethod getChatMember(long chatId, long userId) {
        return new GetChatMemberMethod().setChatId(chatId).setUserId(userId);
    }


    public static GetChatMemberCountMethod getChatMemberCount() {
        return new GetChatMemberCountMethod();
    }

    public static GetChatMemberCountMethod getChatMemberCount(@NotNull String chatId) {
        return new GetChatMemberCountMethod().setChatId(chatId);
    }

    public static GetChatMemberCountMethod getChatMemberCount(long chatId) {
        return new GetChatMemberCountMethod().setChatId(chatId);
    }


    public static GetChatMethod getChat() {
        return new GetChatMethod();
    }

    public static GetChatMethod getChat(@NotNull String chatId) {
        return new GetChatMethod().setChatId(chatId);
    }

    public static GetChatMethod getChat(long chatId) {
        return new GetChatMethod().setChatId(chatId);
    }


    public static GetFileMethod getFile() {
        return new GetFileMethod();
    }

    public static GetFileMethod getFile(@NotNull String fileId) {
        return new GetFileMethod().setFileId(fileId);
    }


    public static GetMeMethod getMe() {
        return new GetMeMethod();
    }


    public static GetUserProfilePhotosMethod getUserProfilePhotos() {
        return new GetUserProfilePhotosMethod();
    }

    public static GetUserProfilePhotosMethod getUserProfilePhotos(long userId) {
        return new GetUserProfilePhotosMethod().setUserId(userId);
    }


    public static GetMyDefaultAdministratorRightsMethod getMyDefaultAdministratorRightsMethod() {
        return new GetMyDefaultAdministratorRightsMethod();
    }

    public static GetMyDefaultAdministratorRightsMethod getMyDefaultAdministratorRightsMethod(boolean forChannels) {
        return new GetMyDefaultAdministratorRightsMethod().setForChannels(forChannels);
    }

    public static SetMyDefaultAdministratorRightsMethod setMyDefaultAdministratorRightsMethod() {
        return new SetMyDefaultAdministratorRightsMethod();
    }

    public static SetMyDefaultAdministratorRightsMethod setMyDefaultAdministratorRightsMethod(boolean forChannels) {
        return new SetMyDefaultAdministratorRightsMethod().setForChannels(forChannels);
    }

    public static SetMyDefaultAdministratorRightsMethod setMyDefaultAdministratorRightsMethod(ChatAdministratorRights rights) {
        return new SetMyDefaultAdministratorRightsMethod().setRights(rights);
    }

    public static GetChatMenuButtonMethod getChatMenuButton() {
        return new GetChatMenuButtonMethod();
    }

    public static GetChatMenuButtonMethod getChatMenuButton(@NotNull String chatId) {
        return new GetChatMenuButtonMethod().setChatId(chatId);
    }

    public static GetChatMenuButtonMethod getChatMenuButton(long chatId) {
        return new GetChatMenuButtonMethod().setChatId(chatId);
    }

    public static SetChatMenuButtonMethod setChatMenuButton() {
        return new SetChatMenuButtonMethod();
    }

    public static SetChatMenuButtonMethod setChatMenuButton(@NotNull String chatId) {
        return new SetChatMenuButtonMethod().setChatId(chatId);
    }

    public static SetChatMenuButtonMethod setChatMenuButton(long chatId) {
        return new SetChatMenuButtonMethod().setChatId(chatId);
    }


    public static GetMyCommandsMethod getMyCommands() {
        return new GetMyCommandsMethod();
    }

    public static GetMyCommandsMethod getMyCommands(BotCommandScope scope){
        return new GetMyCommandsMethod().setScope(scope);
    }

    public static SetMyCommandsMethod setMyCommands() {
        return new SetMyCommandsMethod();
    }

    public static SetMyCommandsMethod setMyCommands(List<BotCommand> commands) {
        return new SetMyCommandsMethod().setCommands(commands);
    }

    public static DeleteMyCommandsMethod deleteMyCommands(){
        return new DeleteMyCommandsMethod();
    }

    public static DeleteMyCommandsMethod deleteMyCommands(BotCommandScope scope){
        return new DeleteMyCommandsMethod().setScope(scope);
    }


    // Send

    public static SendAnimationMethod sendAnimation() {
        return new SendAnimationMethod();
    }

    public static SendAnimationMethod sendAnimation(@NotNull String chatId) {
        return new SendAnimationMethod().setChatId(chatId);
    }

    public static SendAnimationMethod sendAnimation(long chatId) {
        return new SendAnimationMethod().setChatId(chatId);
    }


    public static SendAudioMethod sendAudio() {
        return new SendAudioMethod();
    }

    public static SendAudioMethod sendAudio(@NotNull String chatId) {
        return new SendAudioMethod().setChatId(chatId);
    }

    public static SendAudioMethod sendAudio(long chatId) {
        return new SendAudioMethod().setChatId(chatId);
    }


    public static SendContactMethod sendContact() {
        return new SendContactMethod();
    }

    public static SendContactMethod sendContact(@NotNull String chatId,
                                                @NotNull String phoneNumber, @NotNull String firstName) {
        return new SendContactMethod().setChatId(chatId).setPhoneNumber(phoneNumber).setFirstName(firstName);
    }

    public static SendContactMethod sendContact(long chatId,
                                                @NotNull String phoneNumber, @NotNull String firstName) {
        return new SendContactMethod().setChatId(chatId).setPhoneNumber(phoneNumber).setFirstName(firstName);
    }


    public static SendDiceMethod sendDice() {
        return new SendDiceMethod();
    }

    public static SendDiceMethod sendDice(@NotNull String chatId) {
        return new SendDiceMethod().setChatId(chatId);
    }

    public static SendDiceMethod sendDice(long chatId) {
        return new SendDiceMethod().setChatId(chatId);
    }


    public static SendDocumentMethod sendDocument() {
        return new SendDocumentMethod();
    }

    public static SendDocumentMethod sendDocument(@NotNull String chatId) {
        return new SendDocumentMethod().setChatId(chatId);
    }

    public static SendDocumentMethod sendDocument(long chatId) {
        return new SendDocumentMethod().setChatId(chatId);
    }


    public static SendLocationMethod sendLocation() {
        return new SendLocationMethod();
    }

    public static SendLocationMethod sendLocation(@NotNull String chatId, double latitude, double longitude) {
        return new SendLocationMethod().setChatId(chatId).setLatitude(latitude).setLongitude(longitude);
    }

    public static SendLocationMethod sendLocation(long chatId, double latitude, double longitude) {
        return new SendLocationMethod().setChatId(chatId).setLatitude(latitude).setLongitude(longitude);
    }


    public static SendMediaGroupMethod sendMediaGroup() {
        return new SendMediaGroupMethod();
    }

    public static SendMediaGroupMethod sendMediaGroup(@NotNull String chatId, @NotNull List<InputMedia> media) {
        return new SendMediaGroupMethod().setChatId(chatId).setMedias(media);
    }

    public static SendMediaGroupMethod sendMediaGroup(long chatId, @NotNull List<InputMedia> media) {
        return new SendMediaGroupMethod().setChatId(chatId).setMedias(media);
    }


    public static SendMessageMethod sendMessage() {
        return new SendMessageMethod();
    }

    public static SendMessageMethod sendMessage(@NotNull String chatId, @NotNull String text) {
        return new SendMessageMethod().setChatId(chatId).setText(text);
    }

    public static SendMessageMethod sendMessage(long chatId, @NotNull String text) {
        return new SendMessageMethod().setChatId(chatId).setText(text);
    }


    public static SendPhotoMethod sendPhoto() {
        return new SendPhotoMethod();
    }

    public static SendPhotoMethod sendPhoto(@NotNull String chatId) {
        return new SendPhotoMethod().setChatId(chatId);
    }

    public static SendPhotoMethod sendPhoto(long chatId) {
        return new SendPhotoMethod().setChatId(chatId);
    }


    public static SendVenueMethod sendVenue() {
        return new SendVenueMethod();
    }

    public static SendVenueMethod sendVenue(@NotNull String chatId, double latitude, double longitude,
                                            @NotNull String title, @NotNull String address) {
        return new SendVenueMethod().setChatId(chatId)
                .setLatitude(latitude).setLongitude(longitude)
                .setTitle(title).setAddress(address);
    }

    public static SendVenueMethod sendVenue(long chatId, double latitude, double longitude,
                                            @NotNull String title, @NotNull String address) {
        return new SendVenueMethod().setChatId(chatId)
                .setLatitude(latitude).setLongitude(longitude)
                .setTitle(title).setAddress(address);
    }


    public static SendVideoMethod sendVideo() {
        return new SendVideoMethod();
    }

    public static SendVideoMethod sendVideo(@NotNull String chatId) {
        return new SendVideoMethod().setChatId(chatId);
    }

    public static SendVideoMethod sendVideo(long chatId) {
        return new SendVideoMethod().setChatId(chatId);
    }


    public static SendVideoNoteMethod sendVideoNote() {
        return new SendVideoNoteMethod();
    }

    public static SendVideoNoteMethod sendVideoNote(@NotNull String chatId) {
        return new SendVideoNoteMethod().setChatId(chatId);
    }

    public static SendVideoNoteMethod sendVideoNote(long chatId) {
        return new SendVideoNoteMethod().setChatId(chatId);
    }


    public static SendVoiceMethod sendVoice() {
        return new SendVoiceMethod();
    }

    public static SendVoiceMethod sendVoice(@NotNull String chatId) {
        return new SendVoiceMethod().setChatId(chatId);
    }

    public static SendVoiceMethod sendVoice(long chatId) {
        return new SendVoiceMethod().setChatId(chatId);
    }


    // Updating messages

    public static DeleteMessageMethod deleteMessage() {
        return new DeleteMessageMethod();
    }
    public static DeleteMessageMethod deleteMessage(@NotNull String chatId, int messageId) {
        return new DeleteMessageMethod().setChatId(chatId).setMessageId(messageId);
    }
    public static DeleteMessageMethod deleteMessage(long chatId, int messageId) {
        return new DeleteMessageMethod().setChatId(chatId).setMessageId(messageId);
    }


    public static EditMessageCaptionMethod editMessageCaption() {
        return new EditMessageCaptionMethod();
    }

    public static EditMessageCaptionMethod editMessageCaption(@NotNull String inlineMessageId) {
        return new EditMessageCaptionMethod().setInlineMessageId(inlineMessageId);
    }

    public static EditMessageCaptionMethod editMessageCaption(@NotNull String chatId, int messageId) {
        return new EditMessageCaptionMethod().setChatId(chatId).setMessageId(messageId);
    }

    public static EditMessageCaptionMethod editMessageCaption(long chatId, int messageId) {
        return new EditMessageCaptionMethod().setChatId(chatId).setMessageId(messageId);
    }


    public static EditMessageLiveLocationMethod editMessageLiveLocation() {
        return new EditMessageLiveLocationMethod();
    }

    public static EditMessageLiveLocationMethod editMessageLiveLocation(@NotNull String inlineMessageId,
                                                                        double latitude, double longitude) {
        return new EditMessageLiveLocationMethod().setInlineMessageId(inlineMessageId)
                .setLatitude(latitude).setLongitude(longitude);
    }

    public static EditMessageLiveLocationMethod editMessageLiveLocation(@NotNull String chatId, int messageId,
                                                                        double latitude, double longitude) {
        return new EditMessageLiveLocationMethod().setChatId(chatId).setMessageId(messageId)
                .setLatitude(latitude).setLongitude(longitude);
    }

    public static EditMessageLiveLocationMethod editMessageLiveLocation(long chatId, int messageId,
                                                                        double latitude, double longitude) {
        return new EditMessageLiveLocationMethod().setChatId(chatId).setMessageId(messageId)
                .setLatitude(latitude).setLongitude(longitude);
    }


    public static EditMessageMediaMethod editMessageMedia() {
        return new EditMessageMediaMethod();
    }

    public static EditMessageMediaMethod editMessageMedia(@NotNull String inlineMessageId) {
        return new EditMessageMediaMethod().setInlineMessageId(inlineMessageId);
    }

    public static EditMessageMediaMethod editMessageMedia(@NotNull String chatId, int messageId) {
        return new EditMessageMediaMethod().setChatId(chatId).setMessageId(messageId);
    }

    public static EditMessageMediaMethod editMessageMedia(long chatId, int messageId) {
        return new EditMessageMediaMethod().setChatId(chatId).setMessageId(messageId);
    }


    public static EditMessageReplyMarkupMethod editMessageReplyMarkup() {
        return new EditMessageReplyMarkupMethod();
    }

    public static EditMessageReplyMarkupMethod editMessageReplyMarkup(@NotNull String inlineMessageId) {
        return new EditMessageReplyMarkupMethod().setInlineMessageId(inlineMessageId);
    }

    public static EditMessageReplyMarkupMethod editMessageReplyMarkup(@NotNull String chatId, int messageId) {
        return new EditMessageReplyMarkupMethod().setChatId(chatId).setMessageId(messageId);
    }

    public static EditMessageReplyMarkupMethod editMessageReplyMarkup(long chatId, int messageId) {
        return new EditMessageReplyMarkupMethod().setChatId(chatId).setMessageId(messageId);
    }


    public static EditMessageTextMethod editMessageText() {
        return new EditMessageTextMethod();
    }

    public static EditMessageTextMethod editMessageText(@NotNull String inlineMessageId, @NotNull String text) {
        return new EditMessageTextMethod().setInlineMessageId(inlineMessageId).setText(text);
    }

    public static EditMessageTextMethod editMessageText(@NotNull String chatId, int messageId, @NotNull String text) {
        return new EditMessageTextMethod().setChatId(chatId).setMessageId(messageId).setText(text);
    }

    public static EditMessageTextMethod editMessageText(long chatId, int messageId, @NotNull String text) {
        return new EditMessageTextMethod().setChatId(chatId).setMessageId(messageId).setText(text);
    }


    public static StopMessageLiveLocationMethod stopMessageLiveLocation() {
        return new StopMessageLiveLocationMethod();
    }

    public static StopMessageLiveLocationMethod stopMessageLiveLocation(@NotNull String inlineMessageId) {
        return new StopMessageLiveLocationMethod().setInlineMessageId(inlineMessageId);
    }

    public static StopMessageLiveLocationMethod stopMessageLiveLocation(@NotNull String chatId, int messageId) {
        return new StopMessageLiveLocationMethod().setChatId(chatId).setMessageId(messageId);
    }

    public static StopMessageLiveLocationMethod stopMessageLiveLocation(long chatId, int messageId) {
        return new StopMessageLiveLocationMethod().setChatId(chatId).setMessageId(messageId);
    }


    // Other

    public static ForwardMessageMethod forwardMessage() {
        return new ForwardMessageMethod();
    }

    public static ForwardMessageMethod forwardMessage(@NotNull String toChatId,
                                                      @NotNull String fromChatId, int messageId) {
        return new ForwardMessageMethod().setChatId(toChatId).setFromChatId(fromChatId).setMessageId(messageId);
    }

    public static ForwardMessageMethod forwardMessage(long toChatId, long fromChatId, int messageId) {
        return new ForwardMessageMethod().setChatId(toChatId).setFromChatId(fromChatId).setMessageId(messageId);
    }


    public static CopyMessageMethod copyMessage() {
        return new CopyMessageMethod();
    }

    public static CopyMessageMethod copyMessage(@NotNull String toChatId,
                                                @NotNull String fromChatId, int messageId) {
        return new CopyMessageMethod().setChatId(toChatId).setFromChatId(fromChatId).setMessageId(messageId);
    }

    public static CopyMessageMethod copyMessage(long toChatId, long fromChatId, int messageId) {
        return new CopyMessageMethod().setChatId(toChatId).setFromChatId(fromChatId).setMessageId(messageId);
    }


    public static LeaveChatMethod leaveChat() {
        return new LeaveChatMethod();
    }

    public static LeaveChatMethod leaveChat(@NotNull String chatId) {
        return new LeaveChatMethod().setChatId(chatId);
    }

    public static LeaveChatMethod leaveChat(long chatId) {
        return new LeaveChatMethod().setChatId(chatId);
    }


    public static SendChatActionMethod sendChatAction() {
        return new SendChatActionMethod();
    }

    public static SendChatActionMethod sendChatAction(@NotNull String chatId, @NotNull ActionType actionType) {
        return new SendChatActionMethod().setChatId(chatId);
    }

    public static SendChatActionMethod sendChatAction(long chatId, @NotNull ActionType actionType) {
        return new SendChatActionMethod().setChatId(chatId).setAction(actionType);
    }


    public static AnswerCallbackQueryMethod answerCallbackQuery() {
        return new AnswerCallbackQueryMethod();
    }

    public static AnswerCallbackQueryMethod answerCallbackQuery(@NotNull String callbackQueryId) {
        return new AnswerCallbackQueryMethod().setCallbackQueryId(callbackQueryId);
    }


    public static AnswerInlineQueryMethod answerInlineQuery() {
        return new AnswerInlineQueryMethod();
    }

    public static AnswerInlineQueryMethod answerInlineQuery(@NotNull String inlineQueryId,
                                                            @NotNull List<InlineQueryResult> results) {
        return new AnswerInlineQueryMethod().setInlineQueryId(inlineQueryId).setResults(results);
    }

    public static AnswerInlineQueryMethod answerInlineQuery(@NotNull String inlineQueryId,
                                                            @NotNull InlineQueryResult... results) {
        return new AnswerInlineQueryMethod().setInlineQueryId(inlineQueryId).setResults(results);
    }

    public static AnswerWebAppQueryMethod answerWebAppQuery() {
        return new AnswerWebAppQueryMethod();
    }

    public static AnswerWebAppQueryMethod answerWebAppQuery(@NotNull String webAppQueryId,
                                                            @NotNull InlineQueryResult queryResult) {
        return new AnswerWebAppQueryMethod().setWebAppQueryId(webAppQueryId).setQueryResult(queryResult);
    }
}
