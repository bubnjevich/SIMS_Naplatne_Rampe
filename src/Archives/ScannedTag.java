package Archives;

import Model.Identification;

public class ScannedTag extends Identification {
    Tag tag;

    public ScannedTag(Tag tag) {
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        if (null != this.tag && this.tag.equals(tag))
            this.tag.removeScannedTag(this);
        this.tag = tag;
        if (null != tag)
            tag.addScannedTag(this);
    }
}
