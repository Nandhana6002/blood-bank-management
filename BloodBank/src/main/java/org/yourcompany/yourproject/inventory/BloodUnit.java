package org.yourcompany.yourproject.inventory;
import java.time.LocalDate;

public class BloodUnit{
    private int unitId;
    private BloodGroup bloodGroup;
    private BloodComponent bloodComponent;
    private LocalDate collectionDate;
    private LocalDate expiryDate;
    private BloodStatus status;
    private String donorPhone;

    public BloodUnit(int unitId, BloodGroup bloodGroup, BloodComponent component, String donorPhone, LocalDate collectionDate, BloodStatus status) {
        this.unitId = unitId;
        this.bloodGroup = bloodGroup;
        this.bloodComponent = component;
        this.donorPhone = donorPhone;
        this.collectionDate = collectionDate;
        
        this.expiryDate = collectionDate.plusDays(this.bloodComponent.getShelfLife());
        this.status = status;
    }
    
    public int getUnitId() { 
        return unitId; 
        }
    public void setUnitId(int unitId) { 
        this.unitId = unitId;
         }

    public BloodGroup getBloodGroup() { 
        return bloodGroup; 
        }
    public void setBloodGroup(BloodGroup bloodGroup) {
         this.bloodGroup = bloodGroup; 
        }

    public BloodComponent getComponent() { 
        return bloodComponent; 
        }
    public void setComponent(BloodComponent component) { 
        this.bloodComponent = component;
         }

    public String getDonorPhone() { 
        return donorPhone; 
        }
    public void setDonorPhone(String donorPhone) { 
        this.donorPhone = donorPhone; 
        }

    public LocalDate getCollectionDate() { 
        return collectionDate; 
        }
    public void setCollectionDate(LocalDate collectionDate) { 
        this.collectionDate = collectionDate;
        this.expiryDate = collectionDate.plusDays(bloodComponent.getShelfLife());
    }

    public LocalDate getExpiryDate(){
        return expiryDate;
    }
    
    public BloodStatus getStatus() {
        if (LocalDate.now().isAfter(expiryDate) && status == BloodStatus.AVAILABLE){
            return BloodStatus.EXPIRED;
        }
        return status;
    }

    public void setStatus( BloodStatus status){
        this.status = status;
    }
}