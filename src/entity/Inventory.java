package entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Inventory {

   private List inventory;

   public Inventory() {
      inventory = new LinkedList<Object>();
   }

   public void getInstrumentsFromDB(List instrumentsFromDB) {
      this.inventory = instrumentsFromDB;
   }

   public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
      Instrument instrument = new Instrument(serialNumber, price, spec);
      inventory.add(instrument);
   }

   public Instrument get(String serialNumber) {
      for (Iterator i = inventory.iterator(); i.hasNext();) {
         Instrument instrument = (Instrument) i.next();
         if (instrument.getSerialNumber().equals(serialNumber)) {
            return instrument;
         }
      }
      return null;
   }
   
   public List search(InstrumentSpec searchSpec) {
      List matchingInstruments = new LinkedList<Instrument>();
      for (Iterator i = inventory.iterator(); i.hasNext();) {
         Instrument instrument = (Instrument) i.next();
         if (instrument.getSpec().matches(searchSpec))
            matchingInstruments.add(instrument);
      }
      return matchingInstruments;
   }

   public void remove(String s){
      for (Iterator i = inventory.iterator(); i.hasNext();) {
         Instrument instrument = (Instrument) i.next();
         if(instrument.getSerialNumber().equals(s)){
            i.remove();
         }
      }
   }

   public void update(Instrument modifiedInstrumnet){
      Vector v = new Vector<>();
      for (Iterator i = inventory.iterator(); i.hasNext();) {
         Instrument instrument = (Instrument) i.next();
         if(instrument.getSerialNumber().equals(modifiedInstrumnet.getSerialNumber())){
            i.remove();
            
            v.add(modifiedInstrumnet);
         }
      }
      for(int i = 0; i<v.size();i++){
         inventory.add(v.get(i));
      }
   }
}