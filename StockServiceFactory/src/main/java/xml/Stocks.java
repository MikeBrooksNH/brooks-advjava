package xml;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "stock"
})
@XmlRootElement(name = "stocks")
public class Stocks {
    @XmlElement(required = true)
    protected List<Stock> stock;

    public List<Stock> getStock() {
        return stock;
    }

    /**
     * Sets the value of the father property.
     *
     * @param value
     *     allowed object is
     *     {@link Stock }
     *
     */
    public void setStock(List<Stock> value) {
        this.stock = value;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "Stock=" + stock +
                "}";
    }

}
