package com.kuuhaku.raynor.entity;

import com.kuuhaku.raynor.annotation.MessageUsage;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@MessageUsage(usage="History")
public class History extends BaseEntity{
    private String id = "";
    private String deviceSerial      = ""; //设备编号
    private Date startTime           = null; //开始时间
    private Date endTime             = null; //结束时间
    private String groupName = "";
    private String dashNumber        = ""; //零件编号
    private String operatingPerson   = ""; //操作人
    private String rand              = ""; //随机码--与文件对应
    private Date createTime = null;
    private int times         = 0; //焊接时间

    public History(){
    }

    public boolean equals( Object _object ){
        if( _object instanceof History ){
            History object = (History) _object;
            return this.id.trim().equals( object.getId().trim() );
        }
        return false;
    }

    public int hashCode(){
        return this.id.hashCode();
    }

    public String toString(){
        return id;
    }

    public String getId(){
        return id;
    }

    public void setId( String _id ){
        id = _id;
    }

    public String getDeviceSerial(){
        return deviceSerial;
    }
    public void setDeviceSerial( String _deviceSerial ){
        deviceSerial = _deviceSerial;
    }
    public Date getStartTime(){
        return startTime;
    }
    public void setStartTime( Date _startTime ){
        startTime = _startTime;
    }
    public Date getEndTime(){
        return endTime;
    }
    public void setEndTime( Date _endTime ){
        endTime = _endTime;
    }
    public String getDashNumber(){
        return dashNumber;
    }
    public void setDashNumber( String _dashNumber ){
        dashNumber = _dashNumber;
    }
    public String getOperatingPerson(){
        return operatingPerson;
    }
    public void setOperatingPerson( String _operatingPerson ){
        operatingPerson = _operatingPerson;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public void setCreateTime( Date _createTime ){
        createTime = _createTime;
    }
    public int getTimes(){
        return times;
    }
    public void setTimes( int _times ){
        times = _times;
    }
    public String getGroupName(){
        return groupName;
    }
    public void setGroupName( String _groupName ){
        groupName = _groupName;
    }
     public String getRand(){
         return rand;
     }
     public void setRand( String _rand ){
    	 rand = _rand;
     }

}
