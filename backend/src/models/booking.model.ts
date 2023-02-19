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
  book: (info: IBookProps, token: string) => Promise<IBookReturn | void>;
  unbook: (info: IUnbookProps, token: string) => Promise<IBookReturn | void>;
  bookEvent: (
    info: IBookEventProps,
    token: string
  ) => Promise<IBookEventReturn>;
  getMyEventBook: (token: string) => Promise<IBookReturn>;
}

export class BookingModel implements IBookingModel {
  async book(info: IBookProps, token: string): Promise<IBookReturn | void> {
    try {
      const { data } = await axios.post(
        "https://stud-api.sabir.pro/bookings",
        info,
        {
          headers: {
            Authorization: token,
          },
        }
      );
      return data;
    } catch (e) {
      console.log(`Произошла ошибка: ${e}`);
    }
  }

  async unbook(info: IUnbookProps, token: string): Promise<IBookReturn | void> {
    try {
      const { data } = await axios.put(
        "https://stud-api.sabir.pro/bookings",
        info,
        {
          headers: {
            Authorization: token,
          },
        }
      );
      return data;
    } catch (e) {
      console.log(`Произошла ошибка: ${e}`);
    }
  }

  async bookEvent(
    info: IBookEventProps,
    token: string
  ): Promise<IBookEventReturn> {
    const { data } = await axios.post(
      "https://stud-api.sabir.pro/event-bookings",
      info,
      {
        headers: {
          Authorization: token,
        },
      }
    );
    return data;
  }

  async getMyEventBook(token: string): Promise<IBookReturn> {
    const { data } = await axios.get(
      "https://stud-api.sabir.pro/event-bookings/my",
      {
        headers: {
          Authorization: token,
        },
      }
    );
    return data;
  }
}
