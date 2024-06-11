package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.SetPassportDataErrors;
import org.telegram.telegrambots.meta.api.objects.passport.dataerror.PassportElementError;

public class SetPassportDataErrorsMethod implements UserMethod<SetPassportDataErrorsMethod, Boolean> {

    private final SetPassportDataErrors.SetPassportDataErrorsBuilder method;

    public SetPassportDataErrorsMethod() {
        this(SetPassportDataErrors.builder());
    }

    public SetPassportDataErrorsMethod(@NotNull SetPassportDataErrors.SetPassportDataErrorsBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public SetPassportDataErrorsMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public List<PassportElementError> getErrors() {
        return method.build().getErrors();
    }

    public SetPassportDataErrorsMethod setErrors(@NotNull List<PassportElementError> errors) {
        method.errors(errors);
        return this;
    }

    public SetPassportDataErrorsMethod addError(@NotNull PassportElementError error) {
        var errors = method.build().getErrors();
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(error);
        method.errors(errors);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
