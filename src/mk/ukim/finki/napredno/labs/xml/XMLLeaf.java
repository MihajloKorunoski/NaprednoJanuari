package mk.ukim.finki.napredno.labs.xml;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

class XMLLeaf implements XMLComponent {
    private String tag;
    private String value;
    private Map<String, String> attributes;

    public XMLLeaf(String tag, String value) {
        this.tag = tag;
        this.value = value;
        attributes = new LinkedHashMap<>();
    }

    @Override
    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    @Override
    public String toString() {
        String attrString = attributes.entrySet()
                .stream()
                .map(entry -> entry.getKey()
                        + "=\""
                        + entry.getValue()
                        + "\"")
                .collect(Collectors.joining(" "));
        return "<"
                + tag
                + (attrString.isEmpty() ? "" : " " + attrString)
                + ">"
                + value
                + "</"
                + tag
                + ">";
    }
}
