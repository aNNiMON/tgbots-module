package com.annimon.tgbotsmodule.api.methods;

import com.annimon.tgbotsmodule.api.methods.administration.*;
import com.annimon.tgbotsmodule.api.methods.answerqueries.*;
import com.annimon.tgbotsmodule.api.methods.games.*;
import com.annimon.tgbotsmodule.api.methods.info.*;
import com.annimon.tgbotsmodule.api.methods.other.*;
import com.annimon.tgbotsmodule.api.methods.send.*;
import com.annimon.tgbotsmodule.api.methods.stickers.*;
import com.annimon.tgbotsmodule.api.methods.updates.*;
import com.annimon.tgbotsmodule.api.methods.updatingmessages.*;

@SuppressWarnings("unused")
public final class Methods {

    private Methods() { }

    public static final class Administration {
        private Administration() { }

        public static DeleteChatPhotoMethod deleteChatPhoto() {
            return new DeleteChatPhotoMethod();
        }

        public static DeleteChatStickerSetMethod deleteChatStickerSet() {
            return new DeleteChatStickerSetMethod();
        }

        public static ExportChatInviteLinkMethod exportChatInviteLink() {
            return new ExportChatInviteLinkMethod();
        }

        public static KickChatMemberMethod kickChatMember() {
            return new KickChatMemberMethod();
        }

        public static PinChatMessageMethod pinChatMessage() {
            return new PinChatMessageMethod();
        }

        public static PromoteChatMemberMethod promoteChatMember() {
            return new PromoteChatMemberMethod();
        }

        public static RestrictChatMemberMethod restrictChatMember() {
            return new RestrictChatMemberMethod();
        }

        public static SetChatDescriptionMethod setChatDescription() {
            return new SetChatDescriptionMethod();
        }

        public static SetChatPhotoMethod setChatPhoto() {
            return new SetChatPhotoMethod();
        }

        public static SetChatStickerSetMethod setChatStickerSet() {
            return new SetChatStickerSetMethod();
        }

        public static SetChatTitleMethod setChatTitle() {
            return new SetChatTitleMethod();
        }

        public static UnbanChatMemberMethod unbanChatMember() {
            return new UnbanChatMemberMethod();
        }

        public static UnpinChatMessageMethod unpinChatMessage() {
            return new UnpinChatMessageMethod();
        }
    }
    
    public static class Games {
        private Games() { }

        public static SendGameMethod sendGame() {
            return new SendGameMethod();
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
    }

    public static class Payments {
        private Payments() { }

        public static SendInvoiceMethod sendInvoice() {
            return new SendInvoiceMethod();
        }

        public static AnswerShippingQueryMethod answerShippingQuery() {
            return new AnswerShippingQueryMethod();
        }

        public static AnswerPreCheckoutQueryMethod answerPreCheckoutQuery() {
            return new AnswerPreCheckoutQueryMethod();
        }
    }

    public static class Stickers {
        private Stickers() { }

        public static AddStickerToSetMethod addStickerToSet() {
            return new AddStickerToSetMethod();
        }

        public static CreateNewStickerSetMethod createNewStickerSet() {
            return new CreateNewStickerSetMethod();
        }

        public static DeleteStickerFromSetMethod deleteStickerFromSet() {
            return new DeleteStickerFromSetMethod();
        }

        public static GetStickerSetMethod getStickerSet() {
            return new GetStickerSetMethod();
        }

        public static SetStickerPositionInSetMethod setStickerPositionInSet() {
            return new SetStickerPositionInSetMethod();
        }

        public static SendStickerMethod sendSticker() {
            return new SendStickerMethod();
        }

        public static UploadStickerFileMethod uploadStickerFile() {
            return new UploadStickerFileMethod();
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

    public static GetChatMemberMethod getChatMember() {
        return new GetChatMemberMethod();
    }

    public static GetChatMembersCountMethod getChatMembersCount() {
        return new GetChatMembersCountMethod();
    }

    public static GetChatMethod getChat() {
        return new GetChatMethod();
    }

    public static GetFileMethod getFile() {
        return new GetFileMethod();
    }

    public static GetMeMethod getMe() {
        return new GetMeMethod();
    }

    public static GetUserProfilePhotosMethod getUserProfilePhotos() {
        return new GetUserProfilePhotosMethod();
    }


    // Send

    public static SendAnimationMethod sendAnimation() {
        return new SendAnimationMethod();
    }

    public static SendAudioMethod sendAudio() {
        return new SendAudioMethod();
    }

    public static SendContactMethod sendContact() {
        return new SendContactMethod();
    }

    public static SendDocumentMethod sendDocument() {
        return new SendDocumentMethod();
    }

    public static SendLocationMethod sendLocation() {
        return new SendLocationMethod();
    }

    public static SendMediaGroupMethod sendMediaGroup() {
        return new SendMediaGroupMethod();
    }

    public static SendMessageMethod sendMessage() {
        return new SendMessageMethod();
    }

    public static SendPhotoMethod sendPhoto() {
        return new SendPhotoMethod();
    }

    public static SendVenueMethod sendVenue() {
        return new SendVenueMethod();
    }

    public static SendVideoMethod sendVideo() {
        return new SendVideoMethod();
    }

    public static SendVideoNoteMethod sendVideoNote() {
        return new SendVideoNoteMethod();
    }

    public static SendVoiceMethod sendVoice() {
        return new SendVoiceMethod();
    }


    // Updating messages

    public static DeleteMessageMethod deleteMessage() {
        return new DeleteMessageMethod();
    }

    public static EditMessageCaptionMethod editMessageCaption() {
        return new EditMessageCaptionMethod();
    }

    public static EditMessageLiveLocationMethod editMessageLiveLocation() {
        return new EditMessageLiveLocationMethod();
    }

    public static EditMessageMediaMethod editMessageMedia() {
        return new EditMessageMediaMethod();
    }

    public static EditMessageReplyMarkupMethod editMessageReplyMarkup() {
        return new EditMessageReplyMarkupMethod();
    }

    public static EditMessageTextMethod editMessageText() {
        return new EditMessageTextMethod();
    }

    public static StopMessageLiveLocationMethod stopMessageLiveLocation() {
        return new StopMessageLiveLocationMethod();
    }


    // Other

    public static ForwardMessageMethod forwardMessage() {
        return new ForwardMessageMethod();
    }

    public static LeaveChatMethod leaveChat() {
        return new LeaveChatMethod();
    }

    public static SendChatActionMethod sendChatAction() {
        return new SendChatActionMethod();
    }

    public static AnswerCallbackQueryMethod answerCallbackQuery() {
        return new AnswerCallbackQueryMethod();
    }

    public static AnswerInlineQueryMethod answerInlineQuery() {
        return new AnswerInlineQueryMethod();
    }
}
