package Repository;

public class Factory {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final TollStationRepository tollStationRepository;
    private final TollBothRepository tollBothRepository;
    private final TagRepository tagRepository;
    private final TagOwnerRepository tagOwnerRepository;
    private final RoadSectionRepository roadSectionRepository;
    private final PlaceRepository placeRepository;
    private final PassesRepository passesRepository;
    private final FailuresRepository failuresRepository;

    public Factory() {
        this.vehicleRepository = new VehicleRepository();
        this.userRepository = new UserRepository();
        this.tollStationRepository = new TollStationRepository();
        this.tollBothRepository = new TollBothRepository();
        this.tagRepository = new TagRepository();
        this.tagOwnerRepository = new TagOwnerRepository();
        this.roadSectionRepository = new RoadSectionRepository();
        this.placeRepository = new PlaceRepository();
        this.passesRepository = new PassesRepository();
        this.failuresRepository = new FailuresRepository();
    }

    public FailuresRepository getFailuresRepository() {
        return failuresRepository;
    }

    public PassesRepository getPassesRepository() {
        return passesRepository;
    }

    public PlaceRepository getPlaceRepository() {
        return placeRepository;
    }

    public RoadSectionRepository getRoadSectionRepository() {
        return roadSectionRepository;
    }

    public TagOwnerRepository getTagOwnerRepository() {
        return tagOwnerRepository;
    }

    public TagRepository getTagRepository() {
        return tagRepository;
    }

    public TollBothRepository getTollBothRepository() {
        return tollBothRepository;
    }

    public TollStationRepository getTollStationRepository() {
        return tollStationRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public VehicleRepository getVehicleRepository() {
        return vehicleRepository;
    }
}
