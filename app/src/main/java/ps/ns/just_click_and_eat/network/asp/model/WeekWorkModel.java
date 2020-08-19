package ps.ns.just_click_and_eat.network.asp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeekWorkModel {

    @SerializedName("dayName")
    @Expose
    private String dayName;

    @SerializedName("label")
    @Expose
    private String label;

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
