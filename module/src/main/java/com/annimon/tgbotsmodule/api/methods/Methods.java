package com.annimon.tgbotsmodule.api.methods;

import com.annimon.tgbotsmodule.api.methods.administration.*;
import com.annimon.tgbotsmodule.api.methods.answerqueries.AnswerCallbackQueryMethod;
import com.annimon.tgbotsmodule.api.methods.answerqueries.AnswerInlineQueryMethod;
import com.annimon.tgbotsmodule.api.methods.answerqueries.AnswerPreCheckoutQueryMethod;
import com.annimon.tgbotsmodule.api.methods.answerqueries.AnswerShippingQueryMethod;
import com.annimon.tgbotsmodule.api.methods.answerqueries.AnswerWebAppQueryMethod;
import com.annimon.tgbotsmodule.api.methods.business.*;
import com.annimon.tgbotsmodule.api.methods.forum.*;
import com.annimon.tgbotsmodule.api.methods.games.GetGameHighScoresMethod;
import com.annimon.tgbotsmodule.api.methods.games.SetGameScoreMethod;
import com.annimon.tgbotsmodule.api.methods.gifts.*;
import com.annimon.tgbotsmodule.api.methods.info.*;
import com.annimon.tgbotsmodule.api.methods.invoices.CreateInvoiceLinkMethod;
import com.annimon.tgbotsmodule.api.methods.invoices.EditUserStarSubscriptionMethod;
import com.annimon.tgbotsmodule.api.methods.invoices.GetStarTransactionsMethod;
import com.annimon.tgbotsmodule.api.methods.invoices.RefundStarPaymentMethod;
import com.annimon.tgbotsmodule.api.methods.invoices.SendInvoiceMethod;
import com.annimon.tgbotsmodule.api.methods.other.*;
import com.annimon.tgbotsmodule.api.methods.polls.SendPollMethod;
import com.annimon.tgbotsmodule.api.methods.polls.StopPollMethod;
import com.annimon.tgbotsmodule.api.methods.send.*;
import com.annimon.tgbotsmodule.api.methods.stories.DeleteStoryMethod;
import com.annimon.tgbotsmodule.api.methods.stories.EditStoryMethod;
import com.annimon.tgbotsmodule.api.methods.stories.PostStoryMethod;
import com.annimon.tgbotsmodule.api.methods.stickers.*;
import com.annimon.tgbotsmodule.api.methods.updates.DeleteWebhookMethod;
import com.annimon.tgbotsmodule.api.methods.updates.GetUpdatesMethod;
import com.annimon.tgbotsmodule.api.methods.updates.GetWebhookInfoMethod;
import com.annimon.tgbotsmodule.api.methods.updatingmessages.*;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.objects.ChatPermissions;
import org.telegram.telegrambots.meta.api.objects.adminrights.ChatAdministratorRights;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.passport.dataerror.PassportElementError;
import org.telegram.telegrambots.meta.api.objects.stickers.InputSticker;
import org.telegram.telegrambots.meta.api.objects.stickers.MaskPosition;

@SuppressWarnings("unused")
public final class Methods {

    private Methods() { }

    public static final class Administration {
        private Administration() { }

        public static ApproveChatJoinRequestMethod approveChatJoinRequest() {
            return new ApproveChatJoinRequestMethod();
        }

        public static ApproveChatJoinRequestMethod approveChatJoinRequest(@NotNull String chatId, long userId) {
            return approveChatJoinRequest().setChatId(chatId).setUserId(userId);
        }

        public static ApproveChatJoinRequestMethod approveChatJoinRequest(long chatId, long userId) {
            return approveChatJoinRequest().setChatId(chatId).setUserId(userId);
        }


        public static CreateChatInviteLinkMethod createChatInviteLink() {
            return new CreateChatInviteLinkMethod();
        }

        public static CreateChatInviteLinkMethod createChatInviteLink(@NotNull String chatId) {
            return createChatInviteLink().setChatId(chatId);
        }

        public static CreateChatInviteLinkMethod createChatInviteLink(long chatId) {
            return createChatInviteLink().setChatId(chatId);
        }


        public static CreateChatSubscriptionInviteLinkMethod createChatSubscriptionInviteLink() {
            return new CreateChatSubscriptionInviteLinkMethod();
        }

        public static CreateChatSubscriptionInviteLinkMethod createChatSubscriptionInviteLink(@NotNull String chatId) {
            return createChatSubscriptionInviteLink().setChatId(chatId);
        }

        public static CreateChatSubscriptionInviteLinkMethod createChatSubscriptionInviteLink(long chatId) {
            return createChatSubscriptionInviteLink().setChatId(chatId);
        }


        public static DeclineChatJoinRequestMethod declineChatJoinRequest() {
            return new DeclineChatJoinRequestMethod();
        }

        public static DeclineChatJoinRequestMethod declineChatJoinRequest(@NotNull String chatId, long userId) {
            return declineChatJoinRequest().setChatId(chatId).setUserId(userId);
        }

        public static DeclineChatJoinRequestMethod declineChatJoinRequest(long chatId, long userId) {
            return declineChatJoinRequest().setChatId(chatId).setUserId(userId);
        }


        public static DeleteChatPhotoMethod deleteChatPhoto() {
            return new DeleteChatPhotoMethod();
        }

        public static DeleteChatPhotoMethod deleteChatPhoto(@NotNull String chatId) {
            return deleteChatPhoto().setChatId(chatId);
        }

        public static DeleteChatPhotoMethod deleteChatPhoto(long chatId) {
            return deleteChatPhoto().setChatId(chatId);
        }


        public static DeleteChatStickerSetMethod deleteChatStickerSet() {
            return new DeleteChatStickerSetMethod();
        }

        public static DeleteChatStickerSetMethod deleteChatStickerSet(@NotNull String chatId) {
            return deleteChatStickerSet().setChatId(chatId);
        }

        public static DeleteChatStickerSetMethod deleteChatStickerSet(long chatId) {
            return deleteChatStickerSet().setChatId(chatId);
        }


        public static EditChatInviteLinkMethod editChatInviteLink() {
            return new EditChatInviteLinkMethod();
        }

        public static EditChatInviteLinkMethod editChatInviteLink(@NotNull String chatId, String inviteLink) {
            return editChatInviteLink().setChatId(chatId).setInviteLink(inviteLink);
        }

        public static EditChatInviteLinkMethod editChatInviteLink(long chatId, String inviteLink) {
            return editChatInviteLink().setChatId(chatId).setInviteLink(inviteLink);
        }


        public static EditChatSubscriptionInviteLinkMethod editChatSubscriptionInviteLink() {
            return new EditChatSubscriptionInviteLinkMethod();
        }

        public static EditChatSubscriptionInviteLinkMethod editChatSubscriptionInviteLink(@NotNull String chatId, String inviteLink) {
            return editChatSubscriptionInviteLink().setChatId(chatId).setInviteLink(inviteLink);
        }

        public static EditChatSubscriptionInviteLinkMethod editChatSubscriptionInviteLink(long chatId, String inviteLink) {
            return editChatSubscriptionInviteLink().setChatId(chatId).setInviteLink(inviteLink);
        }


        public static ExportChatInviteLinkMethod exportChatInviteLink() {
            return new ExportChatInviteLinkMethod();
        }

        public static ExportChatInviteLinkMethod exportChatInviteLink(@NotNull String chatId) {
            return exportChatInviteLink().setChatId(chatId);
        }

        public static ExportChatInviteLinkMethod exportChatInviteLink(long chatId) {
            return exportChatInviteLink().setChatId(chatId);
        }


        public static BanChatMemberMethod banChatMember() {
            return new BanChatMemberMethod();
        }

        public static BanChatMemberMethod banChatMember(@NotNull String chatId, long userId) {
            return banChatMember().setChatId(chatId).setUserId(userId);
        }

        public static BanChatMemberMethod banChatMember(long chatId, long userId) {
            return banChatMember().setChatId(chatId).setUserId(userId);
        }


        public static BanChatSenderChatMethod banChatSenderChat() {
            return new BanChatSenderChatMethod();
        }

        public static BanChatSenderChatMethod banChatSenderChat(@NotNull String chatId, long senderChatId) {
            return banChatSenderChat().setChatId(chatId).setSenderChatId(senderChatId);
        }

        public static BanChatSenderChatMethod banChatSenderChat(long chatId, long senderChatId) {
            return banChatSenderChat().setChatId(chatId).setSenderChatId(senderChatId);
        }


        public static PinChatMessageMethod pinChatMessage() {
            return new PinChatMessageMethod();
        }

        public static PinChatMessageMethod pinChatMessage(@NotNull String chatId, int messageId) {
            return pinChatMessage().setChatId(chatId).setMessageId(messageId);
        }

        public static PinChatMessageMethod pinChatMessage(long chatId, int messageId) {
            return pinChatMessage().setChatId(chatId).setMessageId(messageId);
        }


        public static PromoteChatMemberMethod promoteChatMember() {
            return new PromoteChatMemberMethod();
        }

        public static PromoteChatMemberMethod promoteChatMember(@NotNull String chatId, long userId) {
            return promoteChatMember().setChatId(chatId).setUserId(userId);
        }

        public static PromoteChatMemberMethod promoteChatMember(long chatId, long userId) {
            return promoteChatMember().setChatId(chatId).setUserId(userId);
        }


        public static RestrictChatMemberMethod restrictChatMember() {
            return new RestrictChatMemberMethod();
        }

        public static RestrictChatMemberMethod restrictChatMember(@NotNull String chatId, long userId) {
            return restrictChatMember().setChatId(chatId).setUserId(userId);
        }

        public static RestrictChatMemberMethod restrictChatMember(long chatId, long userId) {
            return restrictChatMember().setChatId(chatId).setUserId(userId);
        }


        public static RevokeChatInviteLinkMethod revokeChatInviteLink() {
            return new RevokeChatInviteLinkMethod();
        }

        public static RevokeChatInviteLinkMethod revokeChatInviteLink(@NotNull String chatId, String inviteLink) {
            return revokeChatInviteLink().setChatId(chatId).setInviteLink(inviteLink);
        }

        public static RevokeChatInviteLinkMethod revokeChatInviteLink(long chatId, String inviteLink) {
            return revokeChatInviteLink().setChatId(chatId).setInviteLink(inviteLink);
        }


        public static SetChatAdministratorCustomTitleMethod setChatAdministratorCustomTitle() {
            return new SetChatAdministratorCustomTitleMethod();
        }

        public static SetChatAdministratorCustomTitleMethod setChatAdministratorCustomTitle(@NotNull String chatId, long userId) {
            return setChatAdministratorCustomTitle().setChatId(chatId).setUserId(userId);
        }

        public static SetChatAdministratorCustomTitleMethod setChatAdministratorCustomTitle(long chatId, long userId) {
            return setChatAdministratorCustomTitle().setChatId(chatId).setUserId(userId);
        }


        public static SetChatDescriptionMethod setChatDescription() {
            return new SetChatDescriptionMethod();
        }

        public static SetChatDescriptionMethod setChatDescription(@NotNull String chatId, @NotNull String description) {
            return setChatDescription().setChatId(chatId).setDescription(description);
        }

        public static SetChatDescriptionMethod setChatDescription(long chatId, @NotNull String description) {
            return setChatDescription().setChatId(chatId).setDescription(description);
        }


        public static SetChatPermissionsMethod setChatPermissions() {
            return new SetChatPermissionsMethod();
        }

        public static SetChatPermissionsMethod setChatDescription(@NotNull String chatId, @NotNull ChatPermissions permissions) {
            return setChatPermissions().setChatId(chatId).setPermissions(permissions);
        }

        public static SetChatPermissionsMethod setChatDescription(long chatId, @NotNull ChatPermissions permissions) {
            return setChatPermissions().setChatId(chatId).setPermissions(permissions);
        }


        public static SetChatPhotoMethod setChatPhoto() {
            return new SetChatPhotoMethod();
        }

        public static SetChatPhotoMethod setChatPhoto(@NotNull String chatId) {
            return setChatPhoto().setChatId(chatId);
        }

        public static SetChatPhotoMethod setChatPhoto(long chatId) {
            return setChatPhoto().setChatId(chatId);
        }


        public static SetChatStickerSetMethod setChatStickerSet() {
            return new SetChatStickerSetMethod();
        }

        public static SetChatStickerSetMethod setChatStickerSet(@NotNull String chatId, @NotNull String stickerSetName) {
            return setChatStickerSet().setChatId(chatId).setStickerSetName(stickerSetName);
        }

        public static SetChatStickerSetMethod setChatStickerSet(long chatId, @NotNull String stickerSetName) {
            return setChatStickerSet().setChatId(chatId).setStickerSetName(stickerSetName);
        }


        public static SetChatTitleMethod setChatTitle() {
            return new SetChatTitleMethod();
        }

        public static SetChatTitleMethod setChatTitle(@NotNull String chatId, @NotNull String title) {
            return setChatTitle().setChatId(chatId).setTitle(title);
        }

        public static SetChatTitleMethod setChatTitle(long chatId, @NotNull String title) {
            return setChatTitle().setChatId(chatId).setTitle(title);
        }


        public static UnbanChatMemberMethod unbanChatMember() {
            return new UnbanChatMemberMethod();
        }

        public static UnbanChatMemberMethod unbanChatMember(@NotNull String chatId, long userId) {
            return unbanChatMember().setChatId(chatId).setUserId(userId);
        }

        public static UnbanChatMemberMethod unbanChatMember(long chatId, long userId) {
            return unbanChatMember().setChatId(chatId).setUserId(userId);
        }


        public static UnbanChatSenderChatMethod unbanChatSenderChat() {
            return new UnbanChatSenderChatMethod();
        }

        public static UnbanChatSenderChatMethod unbanChatSenderChat(@NotNull String chatId, long senderChatId) {
            return unbanChatSenderChat().setChatId(chatId).setSenderChatId(senderChatId);
        }

        public static UnbanChatSenderChatMethod unbanChatSenderChat(long chatId, long senderChatId) {
            return unbanChatSenderChat().setChatId(chatId).setSenderChatId(senderChatId);
        }


        public static UnpinChatMessageMethod unpinChatMessage() {
            return new UnpinChatMessageMethod();
        }

        public static UnpinChatMessageMethod unpinChatMessage(@NotNull String chatId) {
            return unpinChatMessage().setChatId(chatId);
        }

        public static UnpinChatMessageMethod unpinChatMessage(long chatId) {
            return unpinChatMessage().setChatId(chatId);
        }


        public static UnpinAllChatMessagesMethod unpinAllChatMessages() {
            return new UnpinAllChatMessagesMethod();
        }

        public static UnpinAllChatMessagesMethod unpinAllChatMessages(@NotNull String chatId) {
            return unpinAllChatMessages().setChatId(chatId);
        }

        public static UnpinAllChatMessagesMethod unpinAllChatMessages(long chatId) {
            return unpinAllChatMessages().setChatId(chatId);
        }
    }

    public static class Business {
        private Business() { }


        public static GetBusinessConnectionMethod getBusinessConnection() {
            return new GetBusinessConnectionMethod();
        }

        public static GetBusinessConnectionMethod getBusinessConnection(String businessConnectionId) {
            return getBusinessConnection().setBusinessConnectionId(businessConnectionId);
        }

        public static DeleteBusinessMessagesMethod deleteBusinessMessages() {
            return new DeleteBusinessMessagesMethod();
        }

        public static GetBusinessAccountGiftsMethod getBusinessAccountGifts() {
            return new GetBusinessAccountGiftsMethod();
        }

        public static GetBusinessAccountStarBalanceMethod getBusinessAccountStarBalance() {
            return new GetBusinessAccountStarBalanceMethod();
        }

        public static ReadBusinessMessageMethod readBusinessMessage() {
            return new ReadBusinessMessageMethod();
        }

        public static RemoveBusinessAccountProfilePhotoMethod removeBusinessAccountProfilePhoto() {
            return new RemoveBusinessAccountProfilePhotoMethod();
        }

        public static SetBusinessAccountNameMethod setBusinessAccountName() {
            return new SetBusinessAccountNameMethod();
        }

        public static SetBusinessAccountBioMethod setBusinessAccountBio() {
            return new SetBusinessAccountBioMethod();
        }

        public static SetBusinessAccountProfilePhotoMethod setBusinessAccountProfilePhoto() {
            return new SetBusinessAccountProfilePhotoMethod();
        }

        public static SetBusinessAccountUsernameMethod setBusinessAccountUsername() {
            return new SetBusinessAccountUsernameMethod();
        }

        public static SetBusinessAccountGiftSettingsMethod setBusinessAccountGiftSettings() {
            return new SetBusinessAccountGiftSettingsMethod();
        }

        public static TransferBusinessAccountStarsMethod transferBusinessAccountStars() {
            return new TransferBusinessAccountStarsMethod();
        }
    }

    public static class Forum {
        private Forum() { }

        public static CreateForumTopicMethod createForumTopic() {
            return new CreateForumTopicMethod();
        }

        public static CreateForumTopicMethod createForumTopic(@NotNull String chatId) {
            return createForumTopic().setChatId(chatId);
        }

        public static CreateForumTopicMethod createForumTopic(long chatId) {
            return createForumTopic().setChatId(chatId);
        }


        public static EditForumTopicMethod editForumTopic() {
            return new EditForumTopicMethod();
        }

        public static EditForumTopicMethod editForumTopic(@NotNull String chatId, int messageThreadId) {
            return editForumTopic().setChatId(chatId).setMessageThreadId(messageThreadId);
        }

        public static EditForumTopicMethod editForumTopic(long chatId, int messageThreadId) {
            return editForumTopic().setChatId(chatId).setMessageThreadId(messageThreadId);
        }


        public static CloseForumTopicMethod closeForumTopic() {
            return new CloseForumTopicMethod();
        }

        public static CloseForumTopicMethod closeForumTopic(@NotNull String chatId, int messageThreadId) {
            return closeForumTopic().setChatId(chatId).setMessageThreadId(messageThreadId);
        }

        public static CloseForumTopicMethod closeForumTopic(long chatId, int messageThreadId) {
            return closeForumTopic().setChatId(chatId).setMessageThreadId(messageThreadId);
        }


        public static ReopenForumTopicMethod reopenForumTopic() {
            return new ReopenForumTopicMethod();
        }

        public static ReopenForumTopicMethod reopenForumTopic(@NotNull String chatId, int messageThreadId) {
            return reopenForumTopic().setChatId(chatId).setMessageThreadId(messageThreadId);
        }

        public static ReopenForumTopicMethod reopenForumTopic(long chatId, int messageThreadId) {
            return reopenForumTopic().setChatId(chatId).setMessageThreadId(messageThreadId);
        }


        public static DeleteForumTopicMethod deleteForumTopic() {
            return new DeleteForumTopicMethod();
        }

        public static DeleteForumTopicMethod deleteForumTopic(@NotNull String chatId, int messageThreadId) {
            return deleteForumTopic().setChatId(chatId).setMessageThreadId(messageThreadId);
        }

        public static DeleteForumTopicMethod deleteForumTopic(long chatId, int messageThreadId) {
            return deleteForumTopic().setChatId(chatId).setMessageThreadId(messageThreadId);
        }


        public static EditGeneralForumTopicMethod editGeneralForumTopic() {
            return new EditGeneralForumTopicMethod();
        }

        public static EditGeneralForumTopicMethod editGeneralForumTopic(@NotNull String chatId) {
            return editGeneralForumTopic().setChatId(chatId);
        }

        public static EditGeneralForumTopicMethod editGeneralForumTopic(long chatId) {
            return editGeneralForumTopic().setChatId(chatId);
        }


        public static CloseGeneralForumTopicMethod closeGeneralForumTopic() {
            return new CloseGeneralForumTopicMethod();
        }

        public static CloseGeneralForumTopicMethod closeGeneralForumTopic(@NotNull String chatId) {
            return closeGeneralForumTopic().setChatId(chatId);
        }

        public static CloseGeneralForumTopicMethod closeGeneralForumTopic(long chatId) {
            return closeGeneralForumTopic().setChatId(chatId);
        }


        public static ReopenGeneralForumTopicMethod reopenGeneralForumTopic() {
            return new ReopenGeneralForumTopicMethod();
        }

        public static ReopenGeneralForumTopicMethod reopenGeneralForumTopic(@NotNull String chatId) {
            return reopenGeneralForumTopic().setChatId(chatId);
        }

        public static ReopenGeneralForumTopicMethod reopenGeneralForumTopic(long chatId) {
            return reopenGeneralForumTopic().setChatId(chatId);
        }


        public static HideGeneralForumTopicMethod hideGeneralForumTopic() {
            return new HideGeneralForumTopicMethod();
        }

        public static HideGeneralForumTopicMethod hideGeneralForumTopic(@NotNull String chatId) {
            return hideGeneralForumTopic().setChatId(chatId);
        }

        public static HideGeneralForumTopicMethod hideGeneralForumTopic(long chatId) {
            return hideGeneralForumTopic().setChatId(chatId);
        }


        public static UnhideGeneralForumTopicMethod unhideGeneralForumTopic() {
            return new UnhideGeneralForumTopicMethod();
        }

        public static UnhideGeneralForumTopicMethod unhideGeneralForumTopic(@NotNull String chatId) {
            return unhideGeneralForumTopic().setChatId(chatId);
        }

        public static UnhideGeneralForumTopicMethod unhideGeneralForumTopic(long chatId) {
            return unhideGeneralForumTopic().setChatId(chatId);
        }


        public static GetForumTopicIconStickersMethod getForumTopicIconStickers() {
            return new GetForumTopicIconStickersMethod();
        }


        public static UnpinAllForumTopicMessagesMethod unpinAllForumTopicMessages() {
            return new UnpinAllForumTopicMessagesMethod();
        }

        public static UnpinAllForumTopicMessagesMethod unpinAllForumTopicMessages(@NotNull String chatId) {
            return unpinAllForumTopicMessages().setChatId(chatId);
        }

        public static UnpinAllForumTopicMessagesMethod unpinAllForumTopicMessages(long chatId) {
            return unpinAllForumTopicMessages().setChatId(chatId);
        }


        public static UnpinAllGeneralForumTopicMessagesMethod unpinAllGeneralForumTopicMessages() {
            return new UnpinAllGeneralForumTopicMessagesMethod();
        }

        public static UnpinAllGeneralForumTopicMessagesMethod unpinAllGeneralForumTopicMessages(@NotNull String chatId) {
            return unpinAllGeneralForumTopicMessages().setChatId(chatId);
        }

        public static UnpinAllGeneralForumTopicMessagesMethod unpinAllGeneralForumTopicMessages(long chatId) {
            return unpinAllGeneralForumTopicMessages().setChatId(chatId);
        }
    }

    public static class Games {
        private Games() { }

        public static SendGameMethod sendGame() {
            return new SendGameMethod();
        }

        public static SendGameMethod sendGame(@NotNull String chatId, @NotNull String gameShortName) {
            return sendGame().setChatId(chatId).setGameShortName(gameShortName);
        }

        public static SendGameMethod sendGame(long chatId, @NotNull String gameShortName) {
            return sendGame().setChatId(chatId).setGameShortName(gameShortName);
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
            return setPassportDataErrors().setUserId(userId);
        }

        public static SetPassportDataErrorsMethod setPassportDataErrors(long userId, @NotNull List<PassportElementError> errors) {
            return setPassportDataErrors().setUserId(userId).setErrors(errors);
        }
    }

    public static class Payments {
        private Payments() { }

        public static SendInvoiceMethod sendInvoice() {
            return new SendInvoiceMethod();
        }

        public static SendInvoiceMethod sendInvoice(@NotNull String chatId) {
            return sendInvoice().setChatId(chatId);
        }

        public static SendInvoiceMethod sendInvoice(long chatId) {
            return sendInvoice().setChatId(chatId);
        }


        public static CreateInvoiceLinkMethod createInvoiceLink() {
            return new CreateInvoiceLinkMethod();
        }


        public static GetStarTransactionsMethod getStarTransactions() {
            return new GetStarTransactionsMethod();
        }


        public static RefundStarPaymentMethod refundStarPayment() {
            return new RefundStarPaymentMethod();
        }

        public static RefundStarPaymentMethod refundStarPayment(long userId) {
            return refundStarPayment().setUserId(userId);
        }


        public static EditUserStarSubscriptionMethod editUserStarSubscription() {
            return new EditUserStarSubscriptionMethod();
        }

        public static EditUserStarSubscriptionMethod editUserStarSubscription(long userId) {
            return editUserStarSubscription().setUserId(userId);
        }


        public static AnswerShippingQueryMethod answerShippingQuery() {
            return new AnswerShippingQueryMethod();
        }

        public static AnswerShippingQueryMethod answerShippingQuery(@NotNull String shippingQueryId, boolean ok) {
            return answerShippingQuery().setShippingQueryId(shippingQueryId).setOk(ok);
        }


        public static AnswerPreCheckoutQueryMethod answerPreCheckoutQuery() {
            return new AnswerPreCheckoutQueryMethod();
        }

        public static AnswerPreCheckoutQueryMethod answerPreCheckoutQuery(@NotNull String preCheckoutQueryId, boolean ok) {
            return answerPreCheckoutQuery().setPreCheckoutQueryId(preCheckoutQueryId).setOk(ok);
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
            return new StopPollMethod().setChatId(chatId).setMessageId(messageId);
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

        public static AddStickerToSetMethod addStickerToSet(long userId, @NotNull String name, @NotNull InputSticker sticker) {
            return addStickerToSet().setUserId(userId).setName(name).setSticker(sticker);
        }


        public static CreateNewStickerSetMethod createNewStickerSet() {
            return new CreateNewStickerSetMethod();
        }

        public static CreateNewStickerSetMethod createNewStickerSet(
                long userId, @NotNull String name, @NotNull String title) {
            return createNewStickerSet().setUserId(userId).setName(name).setTitle(title);
        }


        public static DeleteStickerFromSetMethod deleteStickerFromSet() {
            return new DeleteStickerFromSetMethod();
        }

        public static DeleteStickerFromSetMethod deleteStickerFromSet(@NotNull String sticker) {
            return deleteStickerFromSet().setSticker(sticker);
        }


        public static GetStickerSetMethod getStickerSet() {
            return new GetStickerSetMethod();
        }

        public static GetStickerSetMethod getStickerSet(@NotNull String name) {
            return getStickerSet().setName(name);
        }


        public static DeleteStickerSetMethod deleteStickerSet() {
            return new DeleteStickerSetMethod();
        }

        public static DeleteStickerSetMethod deleteStickerSet(@NotNull String name) {
            return deleteStickerSet().setName(name);
        }


        public static SetStickerPositionInSetMethod setStickerPositionInSet() {
            return new SetStickerPositionInSetMethod();
        }

        public static SetStickerPositionInSetMethod setStickerPositionInSet(@NotNull String sticker, int position) {
            return setStickerPositionInSet().setSticker(sticker).setPosition(position);
        }


        public static SetStickerSetThumbnailMethod setStickerSetThumbnail() {
            return new SetStickerSetThumbnailMethod();
        }

        public static SetStickerSetThumbnailMethod setStickerSetThumbnail(long userId) {
            return setStickerSetThumbnail().setUserId(userId);
        }


        public static SendStickerMethod sendSticker() {
            return new SendStickerMethod();
        }

        public static SendStickerMethod sendSticker(@NotNull String chatId) {
            return sendSticker().setChatId(chatId);
        }

        public static SendStickerMethod sendSticker(long chatId) {
            return sendSticker().setChatId(chatId);
        }


        public static UploadStickerFileMethod uploadStickerFile() {
            return new UploadStickerFileMethod();
        }

        public static UploadStickerFileMethod uploadStickerFile(long userId) {
            return uploadStickerFile().setUserId(userId);
        }


        public static SetCustomEmojiStickerSetThumbnailMethod setCustomEmojiStickerSetThumbnail() {
            return new SetCustomEmojiStickerSetThumbnailMethod();
        }


        public static SetStickerEmojiListMethod setStickerEmojiList() {
            return new SetStickerEmojiListMethod();
        }


        public static SetStickerSetTitleMethod setStickerSetTitle() {
            return new SetStickerSetTitleMethod();
        }

        public static SetStickerSetTitleMethod setStickerSetTitle(@NotNull String name, @NotNull String title) {
            return setStickerSetTitle().setName(name).setTitle(title);
        }


        public static SetStickerKeywordsMethod setStickerKeywords() {
            return new SetStickerKeywordsMethod();
        }

        public static SetStickerKeywordsMethod setStickerKeywords(@NotNull String sticker) {
            return setStickerKeywords().setSticker(sticker);
        }


        public static SetStickerMaskPositionMethod setStickerMaskPosition() {
            return new SetStickerMaskPositionMethod();
        }

        public static SetStickerMaskPositionMethod setStickerMaskPosition(
                @NotNull String sticker,
                @NotNull MaskPosition maskPosition) {
            return setStickerMaskPosition().setSticker(sticker).setMaskPosition(maskPosition);
        }

        public static ReplaceStickerInSetMethod replaceStickerInSet() {
            return new ReplaceStickerInSetMethod();
        }
    }

    public static class Stories {
        private Stories() {}

        public static PostStoryMethod postStory() {
            return new PostStoryMethod();
        }

        public static EditStoryMethod editStory() {
            return new EditStoryMethod();
        }

        public static DeleteStoryMethod deleteStory() {
            return new DeleteStoryMethod();
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

    public static class Gifts {
        private Gifts() {}

        public static GetAvailableGiftsMethod getAvailableGifts() {
            return new GetAvailableGiftsMethod();
        }

        public static SendGiftMethod sendGift() {
            return new SendGiftMethod();
        }

        public static SendGiftMethod sendGift(long userId) {
            return sendGift().setUserId(userId);
        }

        public static ConvertGiftToStarsMethod convertGiftToStars() {
            return new ConvertGiftToStarsMethod();
        }

        public static UpgradeGiftMethod upgradeGift() {
            return new UpgradeGiftMethod();
        }

        public static TransferGiftMethod transferGift() {
            return new TransferGiftMethod();
        }
    }


    // Info
    public static GetChatAdministratorsMethod getChatAdministrators() {
        return new GetChatAdministratorsMethod();
    }

    public static GetChatAdministratorsMethod getChatAdministrators(@NotNull String chatId) {
        return getChatAdministrators().setChatId(chatId);
    }

    public static GetChatAdministratorsMethod getChatAdministrators(long chatId) {
        return getChatAdministrators().setChatId(chatId);
    }


    public static GetChatMemberMethod getChatMember() {
        return new GetChatMemberMethod();
    }

    public static GetChatMemberMethod getChatMember(@NotNull String chatId, long userId) {
        return getChatMember().setChatId(chatId).setUserId(userId);
    }

    public static GetChatMemberMethod getChatMember(long chatId, long userId) {
        return getChatMember().setChatId(chatId).setUserId(userId);
    }


    public static GetChatMemberCountMethod getChatMemberCount() {
        return new GetChatMemberCountMethod();
    }

    public static GetChatMemberCountMethod getChatMemberCount(@NotNull String chatId) {
        return getChatMemberCount().setChatId(chatId);
    }

    public static GetChatMemberCountMethod getChatMemberCount(long chatId) {
        return getChatMemberCount().setChatId(chatId);
    }


    public static GetChatMethod getChat() {
        return new GetChatMethod();
    }

    public static GetChatMethod getChat(@NotNull String chatId) {
        return getChat().setChatId(chatId);
    }

    public static GetChatMethod getChat(long chatId) {
        return getChat().setChatId(chatId);
    }


    public static GetFileMethod getFile() {
        return new GetFileMethod();
    }

    public static GetFileMethod getFile(@NotNull String fileId) {
        return getFile().setFileId(fileId);
    }


    public static GetMeMethod getMe() {
        return new GetMeMethod();
    }


    public static GetMyNameMethod getMyName() {
        return new GetMyNameMethod();
    }

    public static GetMyNameMethod getMyName(@NotNull String languageCode) {
        return getMyName().setLanguageCode(languageCode);
    }

    public static SetMyNameMethod setMyName() {
        return new SetMyNameMethod();
    }

    public static SetMyNameMethod setMyName(@NotNull String name) {
        return setMyName().setName(name);
    }

    public static SetMyNameMethod setMyName(@NotNull String name, @NotNull String languageCode) {
        return setMyName().setName(name).setLanguageCode(languageCode);
    }


    public static GetMyDescriptionMethod getMyDescription() {
        return new GetMyDescriptionMethod();
    }

    public static GetMyDescriptionMethod getMyDescription(@NotNull String languageCode) {
        return getMyDescription().setLanguageCode(languageCode);
    }

    public static SetMyDescriptionMethod setMyDescription() {
        return new SetMyDescriptionMethod();
    }

    public static SetMyDescriptionMethod setMyDescription(@NotNull String description) {
        return setMyDescription().setDescription(description);
    }

    public static SetMyDescriptionMethod setMyDescription(@NotNull String description, @NotNull String languageCode) {
        return setMyDescription().setDescription(description).setLanguageCode(languageCode);
    }


    public static GetMyShortDescriptionMethod getMyShortDescription() {
        return new GetMyShortDescriptionMethod();
    }

    public static GetMyShortDescriptionMethod getMyShortDescription(@NotNull String languageCode) {
        return getMyShortDescription().setLanguageCode(languageCode);
    }

    public static SetMyShortDescriptionMethod setMyShortDescription() {
        return new SetMyShortDescriptionMethod();
    }

    public static SetMyShortDescriptionMethod setMyShortDescription(@NotNull String shortDescription) {
        return setMyShortDescription().setShortDescription(shortDescription);
    }

    public static SetMyShortDescriptionMethod setMyShortDescription(@NotNull String shortDescription, @NotNull String languageCode) {
        return setMyShortDescription().setShortDescription(shortDescription).setLanguageCode(languageCode);
    }


    public static GetMyStarBalanceMethod getMyStarBalance() {
        return new GetMyStarBalanceMethod();
    }


    public static GetUserProfilePhotosMethod getUserProfilePhotos() {
        return new GetUserProfilePhotosMethod();
    }

    public static GetUserProfilePhotosMethod getUserProfilePhotos(long userId) {
        return getUserProfilePhotos().setUserId(userId);
    }


    public static GetMyDefaultAdministratorRightsMethod getMyDefaultAdministratorRights() {
        return new GetMyDefaultAdministratorRightsMethod();
    }

    public static GetMyDefaultAdministratorRightsMethod getMyDefaultAdministratorRights(boolean forChannels) {
        return getMyDefaultAdministratorRights().setForChannels(forChannels);
    }

    public static SetMyDefaultAdministratorRightsMethod setMyDefaultAdministratorRights() {
        return new SetMyDefaultAdministratorRightsMethod();
    }

    public static SetMyDefaultAdministratorRightsMethod setMyDefaultAdministratorRights(boolean forChannels) {
        return setMyDefaultAdministratorRights().setForChannels(forChannels);
    }

    public static SetMyDefaultAdministratorRightsMethod setMyDefaultAdministratorRights(ChatAdministratorRights rights) {
        return setMyDefaultAdministratorRights().setRights(rights);
    }


    public static GetChatMenuButtonMethod getChatMenuButton() {
        return new GetChatMenuButtonMethod();
    }

    public static GetChatMenuButtonMethod getChatMenuButton(@NotNull String chatId) {
        return getChatMenuButton().setChatId(chatId);
    }

    public static GetChatMenuButtonMethod getChatMenuButton(long chatId) {
        return getChatMenuButton().setChatId(chatId);
    }

    public static SetChatMenuButtonMethod setChatMenuButton() {
        return new SetChatMenuButtonMethod();
    }

    public static SetChatMenuButtonMethod setChatMenuButton(@NotNull String chatId) {
        return setChatMenuButton().setChatId(chatId);
    }

    public static SetChatMenuButtonMethod setChatMenuButton(long chatId) {
        return setChatMenuButton().setChatId(chatId);
    }


    public static GetMyCommandsMethod getMyCommands() {
        return new GetMyCommandsMethod();
    }

    public static GetMyCommandsMethod getMyCommands(BotCommandScope scope) {
        return getMyCommands().setScope(scope);
    }

    public static SetMyCommandsMethod setMyCommands() {
        return new SetMyCommandsMethod();
    }

    public static SetMyCommandsMethod setMyCommands(List<BotCommand> commands) {
        return setMyCommands().setCommands(commands);
    }

    public static DeleteMyCommandsMethod deleteMyCommands() {
        return new DeleteMyCommandsMethod();
    }

    public static DeleteMyCommandsMethod deleteMyCommands(BotCommandScope scope) {
        return deleteMyCommands().setScope(scope);
    }

    public static SetUserEmojiStatusMethod setUserEmojiStatus() {
        return new SetUserEmojiStatusMethod();
    }

    public static SetUserEmojiStatusMethod setUserEmojiStatus(long userId) {
        return setUserEmojiStatus().setUserId(userId);
    }


    // Send

    public static SendAnimationMethod sendAnimation() {
        return new SendAnimationMethod();
    }

    public static SendAnimationMethod sendAnimation(@NotNull String chatId) {
        return sendAnimation().setChatId(chatId);
    }

    public static SendAnimationMethod sendAnimation(long chatId) {
        return sendAnimation().setChatId(chatId);
    }


    public static SendAudioMethod sendAudio() {
        return new SendAudioMethod();
    }

    public static SendAudioMethod sendAudio(@NotNull String chatId) {
        return sendAudio().setChatId(chatId);
    }

    public static SendAudioMethod sendAudio(long chatId) {
        return sendAudio().setChatId(chatId);
    }


    public static SendChecklistMethod sendChecklist() {
        return new SendChecklistMethod();
    }

    public static SendChecklistMethod sendChecklist(@NotNull String chatId) {
        return sendChecklist().setChatId(chatId);
    }

    public static SendChecklistMethod sendChecklist(long chatId) {
        return sendChecklist().setChatId(chatId);
    }


    public static SendContactMethod sendContact() {
        return new SendContactMethod();
    }

    public static SendContactMethod sendContact(@NotNull String chatId,
                                                @NotNull String phoneNumber, @NotNull String firstName) {
        return sendContact().setChatId(chatId).setPhoneNumber(phoneNumber).setFirstName(firstName);
    }

    public static SendContactMethod sendContact(long chatId,
                                                @NotNull String phoneNumber, @NotNull String firstName) {
        return sendContact().setChatId(chatId).setPhoneNumber(phoneNumber).setFirstName(firstName);
    }


    public static SendDiceMethod sendDice() {
        return new SendDiceMethod();
    }

    public static SendDiceMethod sendDice(@NotNull String chatId) {
        return sendDice().setChatId(chatId);
    }

    public static SendDiceMethod sendDice(long chatId) {
        return sendDice().setChatId(chatId);
    }


    public static SendDocumentMethod sendDocument() {
        return new SendDocumentMethod();
    }

    public static SendDocumentMethod sendDocument(@NotNull String chatId) {
        return sendDocument().setChatId(chatId);
    }

    public static SendDocumentMethod sendDocument(long chatId) {
        return sendDocument().setChatId(chatId);
    }


    public static SendLocationMethod sendLocation() {
        return new SendLocationMethod();
    }

    public static SendLocationMethod sendLocation(@NotNull String chatId, double latitude, double longitude) {
        return sendLocation().setChatId(chatId).setLatitude(latitude).setLongitude(longitude);
    }

    public static SendLocationMethod sendLocation(long chatId, double latitude, double longitude) {
        return sendLocation().setChatId(chatId).setLatitude(latitude).setLongitude(longitude);
    }


    public static SendMediaGroupMethod sendMediaGroup() {
        return new SendMediaGroupMethod();
    }

    public static SendMediaGroupMethod sendMediaGroup(@NotNull String chatId, @NotNull List<InputMedia> media) {
        return sendMediaGroup().setChatId(chatId).setMedias(media);
    }

    public static SendMediaGroupMethod sendMediaGroup(long chatId, @NotNull List<InputMedia> media) {
        return sendMediaGroup().setChatId(chatId).setMedias(media);
    }


    public static SendMessageMethod sendMessage() {
        return new SendMessageMethod();
    }

    public static SendMessageMethod sendMessage(@NotNull String chatId, @NotNull String text) {
        return sendMessage().setChatId(chatId).setText(text);
    }

    public static SendMessageMethod sendMessage(long chatId, @NotNull String text) {
        return sendMessage().setChatId(chatId).setText(text);
    }


    public static SendPhotoMethod sendPhoto() {
        return new SendPhotoMethod();
    }

    public static SendPhotoMethod sendPhoto(@NotNull String chatId) {
        return sendPhoto().setChatId(chatId);
    }

    public static SendPhotoMethod sendPhoto(long chatId) {
        return sendPhoto().setChatId(chatId);
    }


    public static SendVenueMethod sendVenue() {
        return new SendVenueMethod();
    }

    public static SendVenueMethod sendVenue(@NotNull String chatId, double latitude, double longitude,
                                            @NotNull String title, @NotNull String address) {
        return sendVenue().setChatId(chatId)
                .setLatitude(latitude).setLongitude(longitude)
                .setTitle(title).setAddress(address);
    }

    public static SendVenueMethod sendVenue(long chatId, double latitude, double longitude,
                                            @NotNull String title, @NotNull String address) {
        return sendVenue().setChatId(chatId)
                .setLatitude(latitude).setLongitude(longitude)
                .setTitle(title).setAddress(address);
    }


    public static SendVideoMethod sendVideo() {
        return new SendVideoMethod();
    }

    public static SendVideoMethod sendVideo(@NotNull String chatId) {
        return sendVideo().setChatId(chatId);
    }

    public static SendVideoMethod sendVideo(long chatId) {
        return sendVideo().setChatId(chatId);
    }


    public static SendVideoNoteMethod sendVideoNote() {
        return new SendVideoNoteMethod();
    }

    public static SendVideoNoteMethod sendVideoNote(@NotNull String chatId) {
        return sendVideoNote().setChatId(chatId);
    }

    public static SendVideoNoteMethod sendVideoNote(long chatId) {
        return sendVideoNote().setChatId(chatId);
    }


    public static SendVoiceMethod sendVoice() {
        return new SendVoiceMethod();
    }

    public static SendVoiceMethod sendVoice(@NotNull String chatId) {
        return sendVoice().setChatId(chatId);
    }

    public static SendVoiceMethod sendVoice(long chatId) {
        return sendVoice().setChatId(chatId);
    }


    public static SendPaidMediaMethod sendPaidMedia() {
        return new SendPaidMediaMethod();
    }

    public static SendPaidMediaMethod sendPaidMedia(@NotNull String chatId) {
        return sendPaidMedia().setChatId(chatId);
    }

    public static SendPaidMediaMethod sendPaidMedia(long chatId) {
        return sendPaidMedia().setChatId(chatId);
    }


    // Updating messages

    public static DeleteMessageMethod deleteMessage() {
        return new DeleteMessageMethod();
    }

    public static DeleteMessageMethod deleteMessage(@NotNull String chatId, int messageId) {
        return deleteMessage().setChatId(chatId).setMessageId(messageId);
    }

    public static DeleteMessageMethod deleteMessage(long chatId, int messageId) {
        return deleteMessage().setChatId(chatId).setMessageId(messageId);
    }


    public static DeleteMessagesMethod deleteMessages() {
        return new DeleteMessagesMethod();
    }

    public static DeleteMessagesMethod deleteMessages(@NotNull String chatId) {
        return deleteMessages().setChatId(chatId);
    }

    public static DeleteMessagesMethod deleteMessages(long chatId) {
        return deleteMessages().setChatId(chatId);
    }


    public static EditMessageCaptionMethod editMessageCaption() {
        return new EditMessageCaptionMethod();
    }

    public static EditMessageCaptionMethod editMessageCaption(@NotNull String inlineMessageId) {
        return editMessageCaption().setInlineMessageId(inlineMessageId);
    }

    public static EditMessageCaptionMethod editMessageCaption(@NotNull String chatId, int messageId) {
        return editMessageCaption().setChatId(chatId).setMessageId(messageId);
    }

    public static EditMessageCaptionMethod editMessageCaption(long chatId, int messageId) {
        return editMessageCaption().setChatId(chatId).setMessageId(messageId);
    }


    public static EditMessageChecklistMethod editMessageChecklist() {
        return new EditMessageChecklistMethod();
    }

    public static EditMessageChecklistMethod editMessageChecklist(@NotNull String chatId, int messageId) {
        return editMessageChecklist().setChatId(chatId).setMessageId(messageId);
    }

    public static EditMessageChecklistMethod editMessageChecklist(long chatId, int messageId) {
        return editMessageChecklist().setChatId(Long.toString(chatId)).setMessageId(messageId);
    }


    public static EditMessageLiveLocationMethod editMessageLiveLocation() {
        return new EditMessageLiveLocationMethod();
    }

    public static EditMessageLiveLocationMethod editMessageLiveLocation(@NotNull String inlineMessageId,
                                                                        double latitude, double longitude) {
        return editMessageLiveLocation().setInlineMessageId(inlineMessageId)
                .setLatitude(latitude).setLongitude(longitude);
    }

    public static EditMessageLiveLocationMethod editMessageLiveLocation(@NotNull String chatId, int messageId,
                                                                        double latitude, double longitude) {
        return editMessageLiveLocation().setChatId(chatId).setMessageId(messageId)
                .setLatitude(latitude).setLongitude(longitude);
    }

    public static EditMessageLiveLocationMethod editMessageLiveLocation(long chatId, int messageId,
                                                                        double latitude, double longitude) {
        return editMessageLiveLocation().setChatId(chatId).setMessageId(messageId)
                .setLatitude(latitude).setLongitude(longitude);
    }


    public static EditMessageMediaMethod editMessageMedia() {
        return new EditMessageMediaMethod();
    }

    public static EditMessageMediaMethod editMessageMedia(@NotNull String inlineMessageId) {
        return editMessageMedia().setInlineMessageId(inlineMessageId);
    }

    public static EditMessageMediaMethod editMessageMedia(@NotNull String chatId, int messageId) {
        return editMessageMedia().setChatId(chatId).setMessageId(messageId);
    }

    public static EditMessageMediaMethod editMessageMedia(long chatId, int messageId) {
        return editMessageMedia().setChatId(chatId).setMessageId(messageId);
    }


    public static EditMessageReplyMarkupMethod editMessageReplyMarkup() {
        return new EditMessageReplyMarkupMethod();
    }

    public static EditMessageReplyMarkupMethod editMessageReplyMarkup(@NotNull String inlineMessageId) {
        return editMessageReplyMarkup().setInlineMessageId(inlineMessageId);
    }

    public static EditMessageReplyMarkupMethod editMessageReplyMarkup(@NotNull String chatId, int messageId) {
        return editMessageReplyMarkup().setChatId(chatId).setMessageId(messageId);
    }

    public static EditMessageReplyMarkupMethod editMessageReplyMarkup(long chatId, int messageId) {
        return editMessageReplyMarkup().setChatId(chatId).setMessageId(messageId);
    }


    public static EditMessageTextMethod editMessageText() {
        return new EditMessageTextMethod();
    }

    public static EditMessageTextMethod editMessageText(@NotNull String inlineMessageId, @NotNull String text) {
        return editMessageText().setInlineMessageId(inlineMessageId).setText(text);
    }

    public static EditMessageTextMethod editMessageText(@NotNull String chatId, int messageId, @NotNull String text) {
        return editMessageText().setChatId(chatId).setMessageId(messageId).setText(text);
    }

    public static EditMessageTextMethod editMessageText(long chatId, int messageId, @NotNull String text) {
        return editMessageText().setChatId(chatId).setMessageId(messageId).setText(text);
    }


    public static StopMessageLiveLocationMethod stopMessageLiveLocation() {
        return new StopMessageLiveLocationMethod();
    }

    public static StopMessageLiveLocationMethod stopMessageLiveLocation(@NotNull String inlineMessageId) {
        return stopMessageLiveLocation().setInlineMessageId(inlineMessageId);
    }

    public static StopMessageLiveLocationMethod stopMessageLiveLocation(@NotNull String chatId, int messageId) {
        return stopMessageLiveLocation().setChatId(chatId).setMessageId(messageId);
    }

    public static StopMessageLiveLocationMethod stopMessageLiveLocation(long chatId, int messageId) {
        return stopMessageLiveLocation().setChatId(chatId).setMessageId(messageId);
    }


    // Other

    public static ForwardMessageMethod forwardMessage() {
        return new ForwardMessageMethod();
    }

    public static ForwardMessageMethod forwardMessage(@NotNull String toChatId,
                                                      @NotNull String fromChatId, int messageId) {
        return forwardMessage().setChatId(toChatId).setFromChatId(fromChatId).setMessageId(messageId);
    }

    public static ForwardMessageMethod forwardMessage(long toChatId, long fromChatId, int messageId) {
        return forwardMessage().setChatId(toChatId).setFromChatId(fromChatId).setMessageId(messageId);
    }


    public static ForwardMessagesMethod forwardMessages() {
        return new ForwardMessagesMethod();
    }

    public static ForwardMessagesMethod forwardMessages(@NotNull String toChatId, @NotNull String fromChatId) {
        return forwardMessages().setChatId(toChatId).setFromChatId(fromChatId);
    }

    public static ForwardMessagesMethod forwardMessages(long toChatId, long fromChatId) {
        return forwardMessages().setChatId(toChatId).setFromChatId(fromChatId);
    }


    public static CopyMessageMethod copyMessage() {
        return new CopyMessageMethod();
    }

    public static CopyMessageMethod copyMessage(@NotNull String toChatId,
                                                @NotNull String fromChatId, int messageId) {
        return copyMessage().setChatId(toChatId).setFromChatId(fromChatId).setMessageId(messageId);
    }

    public static CopyMessageMethod copyMessage(long toChatId, long fromChatId, int messageId) {
        return copyMessage().setChatId(toChatId).setFromChatId(fromChatId).setMessageId(messageId);
    }


    public static CopyMessagesMethod copyMessages() {
        return new CopyMessagesMethod();
    }

    public static CopyMessagesMethod copyMessages(@NotNull String toChatId, @NotNull String fromChatId) {
        return copyMessages().setChatId(toChatId).setFromChatId(fromChatId);
    }

    public static CopyMessagesMethod copyMessages(long toChatId, long fromChatId) {
        return copyMessages().setChatId(toChatId).setFromChatId(fromChatId);
    }


    public static LeaveChatMethod leaveChat() {
        return new LeaveChatMethod();
    }

    public static LeaveChatMethod leaveChat(@NotNull String chatId) {
        return leaveChat().setChatId(chatId);
    }

    public static LeaveChatMethod leaveChat(long chatId) {
        return leaveChat().setChatId(chatId);
    }


    public static SendChatActionMethod sendChatAction() {
        return new SendChatActionMethod();
    }

    public static SendChatActionMethod sendChatAction(@NotNull String chatId, @NotNull ActionType actionType) {
        return sendChatAction().setChatId(chatId).setAction(actionType);
    }

    public static SendChatActionMethod sendChatAction(long chatId, @NotNull ActionType actionType) {
        return sendChatAction().setChatId(chatId).setAction(actionType);
    }


    public static SetMessageReactionMethod setMessageReaction() {
        return new SetMessageReactionMethod();
    }

    public static SetMessageReactionMethod setMessageReaction(@NotNull String chatId, int messageId) {
        return setMessageReaction().setChatId(chatId).setMessageId(messageId);
    }

    public static SetMessageReactionMethod setMessageReaction(long chatId, int messageId) {
        return setMessageReaction().setChatId(chatId).setMessageId(messageId);
    }


    public static AnswerCallbackQueryMethod answerCallbackQuery() {
        return new AnswerCallbackQueryMethod();
    }

    public static AnswerCallbackQueryMethod answerCallbackQuery(@NotNull String callbackQueryId) {
        return answerCallbackQuery().setCallbackQueryId(callbackQueryId);
    }


    public static AnswerInlineQueryMethod answerInlineQuery() {
        return new AnswerInlineQueryMethod();
    }

    public static AnswerInlineQueryMethod answerInlineQuery(@NotNull String inlineQueryId,
                                                            @NotNull List<InlineQueryResult> results) {
        return answerInlineQuery().setInlineQueryId(inlineQueryId).setResults(results);
    }

    public static AnswerInlineQueryMethod answerInlineQuery(@NotNull String inlineQueryId,
                                                            @NotNull InlineQueryResult... results) {
        return answerInlineQuery().setInlineQueryId(inlineQueryId).setResults(results);
    }

    public static AnswerWebAppQueryMethod answerWebAppQuery() {
        return new AnswerWebAppQueryMethod();
    }

    public static AnswerWebAppQueryMethod answerWebAppQuery(@NotNull String webAppQueryId,
                                                            @NotNull InlineQueryResult queryResult) {
        return answerWebAppQuery().setWebAppQueryId(webAppQueryId).setQueryResult(queryResult);
    }

    public static VerifyChatMethod verifyChat() {
        return new VerifyChatMethod();
    }

    public static VerifyChatMethod verifyChat(@NotNull String chatId) {
        return verifyChat().setChatId(chatId);
    }

    public static VerifyChatMethod verifyChat(long chatId) {
        return verifyChat().setChatId(chatId);
    }


    public static VerifyUserMethod verifyUser() {
        return new VerifyUserMethod();
    }

    public static VerifyUserMethod verifyUser(long userId) {
        return verifyUser().setUserId(userId);
    }


    public static RemoveChatVerificationMethod removeChatVerification() {
        return new RemoveChatVerificationMethod();
    }

    public static RemoveChatVerificationMethod removeChatVerification(@NotNull String chatId) {
        return removeChatVerification().setChatId(chatId);
    }

    public static RemoveChatVerificationMethod removeChatVerification(long chatId) {
        return removeChatVerification().setChatId(chatId);
    }


    public static RemoveUserVerificationMethod removeUserVerification() {
        return new RemoveUserVerificationMethod();
    }

    public static RemoveUserVerificationMethod removeUserVerification(long userId) {
        return removeUserVerification().setUserId(userId);
    }
}

