import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
  private final List<? extends Plane> planes;

  public Airport(List<? extends Plane> planes) {
    this.planes = planes;
  }

  public List<PassengerPlane> getPassengerPlane() {
    return planes.stream().filter(PassengerPlane.class::isInstance).map(PassengerPlane.class::cast).toList();
  }

  public List<MilitaryPlane> getMilitaryPlanes() {
    return planes.stream().filter(MilitaryPlane.class::isInstance).map(MilitaryPlane.class::cast).toList();
  }

  public PassengerPlane getPassengerPlaneWithMaxCapacity() {
    return getPassengerPlane().stream()
            .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity)).orElse(null);
  }

  public List<MilitaryPlane> getTypeMilitaryPlanes(MilitaryType militaryType) {
    return getMilitaryPlanes().stream().filter(plane -> plane.getType().equals(militaryType)).toList();
  }

  public List<ExperimentalPlane> getExperimentalPlanes() {
    return planes.stream().filter(ExperimentalPlane.class::isInstance).map(ExperimentalPlane.class::cast).toList();
  }

  public Airport sortByMaxDistance() {
    planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    return this;
  }

  public Airport sortByMaxSpeed() {
    planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    return this;
  }

  public void sortByMaxLoadCapacity() {
    planes.sort(Comparator.comparingInt(Plane::getMinLoadCapacity));
  }

  public List<? extends Plane> getPlanes() {
    return planes;
  }

  @Override
  public String toString() {
    return "Airport{" +
            "Planes=" + planes.toString() +
            '}';
  }
}
