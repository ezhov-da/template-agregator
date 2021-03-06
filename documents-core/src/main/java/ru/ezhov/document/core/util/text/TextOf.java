package ru.ezhov.document.core.util.text;

public final class TextOf implements Text {

    private final Text text;

    public TextOf(Text text) {
        this.text = text;
    }

    public TextOf(final String text) {
        this(() -> text);
    }

    @Override
    public String asString() {
        return text.asString();
    }

    @Override
    public String toString() {
        return "TextOf{" +
                "text=" + text.asString() +
                '}';
    }
}
