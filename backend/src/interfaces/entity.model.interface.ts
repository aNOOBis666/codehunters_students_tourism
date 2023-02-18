export interface INewsReturn {
  userId: string;
  content: string;
  cover: string;
  title: string;
  createdTimestamp: Date;
  updatedTimestamp: Date;
  tags: string[];
  id: string;
  timestamp: Date;
}

export interface IRoomInterface {
  details: {
    isFree: boolean;
    type: string;
    description: string;
    photos: string[];
    amount: string;
    price: string;
  };
  dormitoryId: string;
  userId: string;
  universityId: string;
  createdTimestamp: Date;
  onModeration: boolean;
  updatedTimestamp: Date;
  id: string;
  timestamp: Date;
}

export interface IUniversitiesReturn {
  userId: string;
  name: string;
  description: string;
  details: {
    photo: string;
    name: string;
    site: string;
    committee: string;
    region: string;
    shortName: string;
    district: string;
  };
  isDebug: boolean;
  onModeration: boolean;
  id: string;
  timestamp: Date;
  createdTimestamp: Date;
  updatedTimestamp: Date;
}

export interface IDormitoriesReturn {
  data: {
    userId: string;
    universityId: string;
    createdTimestamp: Date;
    details: {
      "main-info": {
        name: string;
        city: string;
        street: string;
        houseNumber: string;
        coordinates: {
          lat: number;
          lng: number;
        };
        minDays: string;
        maxDays: string;
        photos: string[];
        mealPlan: string;
      };
      rules: {
        requiredUniDocuments: string;
        requiredStudentsDocuments: string;
        committee: {
          email: string;
          phone: string;
          name: string;
        };
      };
      documents: string[];
    };
    onModeration: boolean;
    id: number;
    timestamp: Date;
    updatedTimestamp: Date;
    rooms: {
      [key: string]: IRoomInterface;
    };
  };
}

export interface IRoomsReturn {
  data: {
    details: {
      isFree: boolean;
      type: string;
      amount: string;
      price: string;
      description: string;
      photos: string[];
    };
    dormitoryId: string;
    userId: string;
    universityId: string;
    createdTimestamp: Date;
    updatedTimestamp: Date;
    id: string;
    timestamp: Date;
    onModeration: boolean;
  };
}

export interface IRoomsByIdReturn {
  details: {
    isFree: boolean;
    type: string;
    amount: string;
    price: string;
    description: string;
    photos: string[];
  };
  dormitoryId: string;
  userId: string;
  universityId: string;
  createdTimestamp: Date;
  updatedTimestamp: Date;
  id: string;
  timestamp: Date;
  onModeration: boolean;
}

export interface IUniversityEvent {
  details: {
    dates: {
      from: Date;
      to: Date;
      isRegular: boolean;
    };
    name: string;
    link: string;
    price: string;
    description: string;
    video: string[];
    photos: string[];
    type: string;
    WoS: string;
  };
  userId: string;
  universityId: string;
  createdTimestamp: Date;
  updatedTimestamp: Date;
  onModeration: boolean;
  id: string;
  timestamp: Date;
}

export interface ILabsReturn {
  details: {
    name: string;
    link: string;
    description: string;
    photos: string[];
    coordinates: {
      lat: number;
      lng: number;
    };
    owner: {
      name: string;
      position: string;
      phone: string;
      email: string;
    };
    unit: {
      name: string;
      phone: string;
      email: string;
    };
    admin: {
      name: string;
      phone: string;
      email: string;
    };
    shortDescription: string;
  };
  userId: string;
  universityId: string;
  onModeration: boolean;
  createdTimestamp: Date;
  updatedTimestamp: Date;
  id: string;
  timestamp: Date;
}
