export interface IAuthReturn {
  data: {
    token: string;
  };
}

export interface IMeReturn {
  data: {
    username: string;
    email: string;
    userRole?: string;
    id: string;
    timestamp?: Date;
    createdTimestamp?: Date;
    updatedTimestamp?: Date;
    name?: string;
    lastName?: string;
  };
}

export interface IUpdateMeProps extends IMeReturn {}
