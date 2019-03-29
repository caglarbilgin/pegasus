package mapping;

public enum MapMethodType {

    CLICK_ELEMENT("click_element"), INPUT_ELEMENT("input_element"),IS_ELEMENT("is_element"),SELECT_ELEMENT("select_element");

    private final String value;

    MapMethodType(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
