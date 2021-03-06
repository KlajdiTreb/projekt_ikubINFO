USE [projekti_ikubINFO_db]
GO
ALTER TABLE [dbo].[Punonjes] DROP CONSTRAINT [FK_Punonjes_Roles]
GO
ALTER TABLE [dbo].[Punonjes] DROP CONSTRAINT [FK_Punonjes_Departament]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 10/18/2020 1:18:08 PM ******/
DROP TABLE [dbo].[Roles]
GO
/****** Object:  Table [dbo].[Punonjes]    Script Date: 10/18/2020 1:18:08 PM ******/
DROP TABLE [dbo].[Punonjes]
GO
/****** Object:  Table [dbo].[Departament]    Script Date: 10/18/2020 1:18:08 PM ******/
DROP TABLE [dbo].[Departament]
GO
/****** Object:  Table [dbo].[Departament]    Script Date: 10/18/2020 1:18:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Departament](
	[id_departament] [int] IDENTITY(1,1) NOT NULL,
	[emri_departament] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
 CONSTRAINT [PK_Departament] PRIMARY KEY CLUSTERED 
(
	[id_departament] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Punonjes]    Script Date: 10/18/2020 1:18:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Punonjes](
	[id_punonjes] [int] IDENTITY(1,1) NOT NULL,
	[emri_punonjes] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[mbiemri_punonjes] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[password] [varchar](60) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[email] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[departament_id] [int] NULL,
	[role_id] [int] NULL,
 CONSTRAINT [PK_Punonjes] PRIMARY KEY CLUSTERED 
(
	[id_punonjes] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 10/18/2020 1:18:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Roles](
	[id_role] [int] IDENTITY(1,1) NOT NULL,
	[emri_role] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[id_role] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Departament] ON 

INSERT [dbo].[Departament] ([id_departament], [emri_departament]) VALUES (1, N'HR')
INSERT [dbo].[Departament] ([id_departament], [emri_departament]) VALUES (2, N'Marketing')
INSERT [dbo].[Departament] ([id_departament], [emri_departament]) VALUES (3, N'Java')
INSERT [dbo].[Departament] ([id_departament], [emri_departament]) VALUES (4, N'Python')
INSERT [dbo].[Departament] ([id_departament], [emri_departament]) VALUES (5, N'C#')
SET IDENTITY_INSERT [dbo].[Departament] OFF
SET IDENTITY_INSERT [dbo].[Punonjes] ON 

INSERT [dbo].[Punonjes] ([id_punonjes], [emri_punonjes], [mbiemri_punonjes], [password], [email], [departament_id], [role_id]) VALUES (1, N'Kjara', N'Dika', N'1230', N'kjara.dika@ikubinfo.al', 1, 1)
INSERT [dbo].[Punonjes] ([id_punonjes], [emri_punonjes], [mbiemri_punonjes], [password], [email], [departament_id], [role_id]) VALUES (2, N'Guido', N'Cota', N'1230', N'guido.cota@ikubinfo.al', 3, 1)
INSERT [dbo].[Punonjes] ([id_punonjes], [emri_punonjes], [mbiemri_punonjes], [password], [email], [departament_id], [role_id]) VALUES (3, N'Klajdi', N'Trebicka', N'1230', N'klajditrebicka@gmail.com', 3, 2)
SET IDENTITY_INSERT [dbo].[Punonjes] OFF
SET IDENTITY_INSERT [dbo].[Roles] ON 

INSERT [dbo].[Roles] ([id_role], [emri_role]) VALUES (1, N'ADMIN')
INSERT [dbo].[Roles] ([id_role], [emri_role]) VALUES (2, N'USER')
SET IDENTITY_INSERT [dbo].[Roles] OFF
ALTER TABLE [dbo].[Punonjes]  WITH CHECK ADD  CONSTRAINT [FK_Punonjes_Departament] FOREIGN KEY([departament_id])
REFERENCES [dbo].[Departament] ([id_departament])
GO
ALTER TABLE [dbo].[Punonjes] CHECK CONSTRAINT [FK_Punonjes_Departament]
GO
ALTER TABLE [dbo].[Punonjes]  WITH CHECK ADD  CONSTRAINT [FK_Punonjes_Roles] FOREIGN KEY([role_id])
REFERENCES [dbo].[Roles] ([id_role])
GO
ALTER TABLE [dbo].[Punonjes] CHECK CONSTRAINT [FK_Punonjes_Roles]
GO
