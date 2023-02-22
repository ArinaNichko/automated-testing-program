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
    List<PassengerPlane> passengerPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof PassengerPlane) {
        passengerPlanes.add((PassengerPlane) plane);
      }
    }
    return passengerPlanes;
  }

  public List<MilitaryPlane> getMilitaryPlanes() {
    List<MilitaryPlane> militaryPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof MilitaryPlane) {
        militaryPlanes.add((MilitaryPlane) plane);
      }
    }
    return militaryPlanes;
  }

  public PassengerPlane getPassengerPlaneWithMaxCapacity() {
    return getPassengerPlane().stream()
            .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity)).orElse(null);
  }

  public List<MilitaryPlane> getTypeMilitaryPlanes(MilitaryType militaryType) {
    return getMilitaryPlanes().stream().filter(plane -> plane.getType().equals(militaryType)).toList();
  }

  public List<ExperimentalPlane> getExperimentalPlanes() {
    List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof ExperimentalPlane) {
        experimentalPlanes.add((ExperimentalPlane) plane);
      }
    }
    return experimentalPlanes;
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
