package ern.dev.vhutils.messages;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.text.minimessage.tag.standard.StandardTags;

public class Builder {

    private static final MiniMessage miniMessage = MiniMessage.builder()
            .tags(TagResolver.builder()
                    .resolver(StandardTags.color())
                    .resolver(StandardTags.decorations())
                    .resolver(StandardTags.gradient())
                    .resolver(StandardTags.rainbow())
                    .resolver(StandardTags.reset())
                    .resolver(StandardTags.clickEvent())
                    .resolver(StandardTags.hoverEvent())
                    .build())
            .build();

    private Component getComp(String s){
        return miniMessage.deserialize(s);
    }

    public Component finalComp(String s){
        return getComp(s.replaceAll("<nl>", "\n"));
    }

}
