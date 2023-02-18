// @ts-ignore
import axios from "axios";

interface IBookProps {
  roomId: string;
  quantity: number;
  dates: {
    from: string;
    to: string;
  };
}

interface IUnbookProps {
  dates: {
    from: string;
    to: string;
  };
  id: string;
  status: "canceled";
}

interface IBookReturn {
  userId: string;
  universityId: string;
  dormitoryId: string;
  roomId: string;
  quantity: number;
  dates: {
    from: string;
    to: string;
  };
  status: string;
  from: string;
  to: string;
  id: string;
  timestamp: Date;
  createdTimestamp: Date;
  updatedTimestamp: Date;
}

interface IBookEventProps {
  details: {
    email: string;
    fullName: string;
    participants: { fullName: string; phone: string; email: string }[];
    phone: string;
    quantity: string;
  };
  eventId: string;
}

interface IBookEventReturn {
  userId: string;
  universityId: string;
  status: "new";
  details: {
    email: string;
    fullName: string;
    participants: {
      fullName: string;
      phone: string;
      email: string;
    }[];
    phone: string;
    quantity: string;
  };
  eventId: string;
  id: string;
  timestamp: Date;
  createdTimestamp: Date;
  updatedTimestamp: Date;
}

interface IBookingModel {
  book: (info: IBookProps) => Promise<IBookReturn>;
  unbook: (info: IUnbookProps) => Promise<IBookReturn>;
  bookEvent: (info: IBookEventProps) => Promise<IBookEventReturn>;
  getMyEventBook: (token: string) => Promise<IBookReturn>;
}

class BookingModel implements IBookingModel {
  async book(info: IBookProps): Promise<IBookReturn> {
    const { data } = await axios.post(
      "https://stud-api.sabir.pro/bookings",
      info
    );
    return data;
  }

  async unbook(info: IUnbookProps): Promise<IBookReturn> {
    const { data } = await axios.put(
      "https://stud-api.sabir.pro/bookings",
      info
    );
    return data;
  }

  async bookEvent(info: IBookEventProps): Promise<IBookEventReturn> {
    const { data } = await axios.post(
      "https://stud-api.sabir.pro/event-bookings",
      info
    );
    return data;
  }

  async getMyEventBook(token: string): Promise<IBookReturn> {
    const { data } = await axios.get(
      "https://stud-api.sabir.pro/event-bookings/my",
      {
        token,
      }
    );
    return data;
  }
}
