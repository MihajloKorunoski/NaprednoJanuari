package mk.ukim.finki.napredno.labs.xml;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class XMLComposite implements XMLComponent {

    private String tag;
    private List<XMLComponent> components;
    private Map<String, String> attributes;

    public XMLComposite(String tag) {
        this.tag = tag;
        this.components = new ArrayList<>();
        this.attributes = new LinkedHashMap<>();
    }

    @Override
    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public void addComponent(XMLComponent component) {
        components.add(component);
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
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tag).append(attrString.isEmpty() ? "" : " " + attrString).append(">\n");
        for(XMLComponent component : components){
            sb.append("\t").append(component.toString().replaceAll("\n","\n\t")).append("\n");
        }
        sb.append("</").append(tag).append(">");
        return sb.toString();
    }
}
